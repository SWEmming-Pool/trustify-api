// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;
pragma experimental ABIEncoderV2;

import "./TransactionLibrary.sol";
import "./ReviewLibrary.sol";

contract ReviewSystem {
    using TransactionLibrary for TransactionLibrary.Transaction[];

    TransactionLibrary.Transaction[] private transactions;
    mapping(address => TransactionLibrary.Transaction[])
        private transactionsBySender;
    mapping(address => TransactionLibrary.Transaction[])
        private transactionsByReceiver;
    mapping(bytes32 => ReviewLibrary.Review) private reviews;

    function sendTransaction(address _receiver) external payable {
        require(msg.value > 0, "The sent amount must be greater than 0");

        bytes32 id = keccak256(
            abi.encodePacked(msg.sender, _receiver, msg.value, block.timestamp)
        );

        transactions.addTransaction(
            msg.sender,
            _receiver,
            msg.value,
            id
        );

        transactionsBySender[msg.sender].addTransaction(
            msg.sender,
            _receiver,
            msg.value,
            id
        );
        transactionsByReceiver[_receiver].addTransaction(
            msg.sender,
            _receiver,
            msg.value,
            id
        );

        payable(_receiver).transfer(msg.value);
    }

    function getTransactionById(bytes32 _id)
        external
        view
        returns (TransactionLibrary.Transaction memory)
    {
        bool found = false;
        uint index = 0;
        
        for(index = 0; index < transactions.length; index++) {
            if(transactions[index].id == _id) {
                found = true;
                break;
            }
        }

        require(found, "Transaction not found");

        return transactions[index];
    }

    function addReview(
        bytes32 _transactionId,
        string memory _title,
        uint8 _rating,
        string memory _text
    )
        external
        transactionSenderOnly(_transactionId)
        transactionExists(_transactionId)
        notAlreadyReviewed(_transactionId)
    {
        require(
            bytes(_title).length <= 50,
            "Title must be less than or equal to 50 characters"
        );

        require(_rating >= 1 && _rating <= 5, "Rating must be between 1 and 5");

        require(
            bytes(_text).length <= 500,
            "Text must be less than or equal to 500 characters"
        );
        ReviewLibrary.Review memory newReview = ReviewLibrary.Review({
            title: _title,
            date: block.timestamp,
            rating: _rating,
            text: _text,
            transactionId: _transactionId
        });

        reviews[_transactionId] = newReview;
    }

    function getUnreviewedTransactions(address _addr)
        external
        view
        returns (TransactionLibrary.Transaction[] memory)
    {
        uint unreviewedCount = 0;

        for (uint i = 0; i < transactionsBySender[_addr].length; i++) {
            if (
                bytes(reviews[transactionsBySender[_addr][i].id].text)
                    .length == 0
            ) {
                unreviewedCount++;
            }
        }

        TransactionLibrary.Transaction[]
            memory unreviewedTransactions = new TransactionLibrary.Transaction[](
                unreviewedCount
            );

        uint j = 0;
        for (uint i = 0; i < transactionsBySender[_addr].length; i++) {
            if (
                bytes(reviews[transactionsBySender[_addr][i].id].text)
                    .length == 0
            ) {
                unreviewedTransactions[j] = transactionsBySender[_addr][i];
                j++;
            }
        }

        return unreviewedTransactions;
    }

    function getReviewById(bytes32 _id)
        external
        view
        returns (ReviewLibrary.Review memory)
    {
        return reviews[_id];
    }

    // UC09
    function getReviewsBySender(
        address _sender
    ) external view returns (ReviewLibrary.Review[] memory) {
        uint reviewCount = 0;

        for (uint i = 0; i < transactionsBySender[_sender].length; i++) {
            if (
                bytes(reviews[transactionsBySender[_sender][i].id].text)
                    .length > 0
            ) {
                reviewCount++;
            }
        }

        ReviewLibrary.Review[]
            memory reviewsForAddress = new ReviewLibrary.Review[](reviewCount);

        uint j = 0;
        for (uint i = 0; i < transactionsBySender[_sender].length; i++) {
            bytes32 id = transactionsBySender[_sender][i].id;
            if (bytes(reviews[id].text).length > 0) {
                reviewsForAddress[j] = reviews[id];
                j++;
            }
        }

        return reviewsForAddress;
    }

    function getReviewsByReceiver(
        address _receiver
    ) external view returns (ReviewLibrary.Review[] memory) {
        uint reviewCount = 0;

        for (uint i = 0; i < transactionsByReceiver[_receiver].length; i++) {
            if (
                bytes(reviews[transactionsByReceiver[_receiver][i].id].text)
                    .length > 0
            ) {
                reviewCount++;
            }
        }

        ReviewLibrary.Review[]
            memory reviewsForAddress = new ReviewLibrary.Review[](reviewCount);

        uint j = 0;
        for (uint i = 0; i < transactionsByReceiver[_receiver].length; i++) {
            bytes32 id = transactionsByReceiver[_receiver][i].id;
            if (bytes(reviews[id].text).length > 0) {
                reviewsForAddress[j] = reviews[id];
                j++;
            }
        }

        return reviewsForAddress;
    }

    //MODIFIERS

    modifier transactionSenderOnly(bytes32 _transactionId) {
        require(
            TransactionLibrary.containsTransaction(
                transactionsBySender[msg.sender],
                _transactionId
            ),
            "Transaction sender is not authorized"
        );
        _;
    }
    modifier transactionExists(bytes32 _transactionId) {
        require(
            transactionsBySender[msg.sender].length > 0,
            "No transactions found for this address"
        );

        TransactionLibrary.Transaction[]
            memory senderTransactions = transactionsBySender[msg.sender];
        bool transactionFound = false;
        for (uint i = 0; i < senderTransactions.length; i++) {
            if (senderTransactions[i].id == _transactionId) {
                transactionFound = true;
                break;
            }
        }
        require(
            transactionFound,
            "No transaction found with the given ID for this address"
        );
        _;
    }
    modifier notAlreadyReviewed(bytes32 _transactionId) {
        require(
            bytes(reviews[_transactionId].text).length == 0,
            "A review for this transaction already exists"
        );
        _;
    }
}
