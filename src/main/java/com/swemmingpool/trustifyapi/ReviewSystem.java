package com.swemmingpool.trustifyapi;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.StaticStruct;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.2.
 */
@SuppressWarnings("rawtypes")
public class ReviewSystem extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061185d806100206000396000f3fe6080604052600436106100705760003560e01c8063381b8b5f1161004e578063381b8b5f146100ed5780633bc624c81461010d578063635aa8cb1461013a578063e933d43d1461015a57600080fd5b806316218c161461007557806329b65962146100ab5780632bd123fe146100d8575b600080fd5b34801561008157600080fd5b50610095610090366004611308565b61017a565b6040516100a2919061135e565b60405180910390f35b3480156100b757600080fd5b506100cb6100c6366004611308565b6103d3565b6040516100a291906113f2565b6100eb6100e6366004611308565b610725565b005b3480156100f957600080fd5b506100eb61010836600461153f565b610857565b34801561011957600080fd5b5061012d6101283660046115c7565b610c5e565b6040516100a291906115f1565b34801561014657600080fd5b5061012d6101553660046115c7565b610cf7565b34801561016657600080fd5b506100cb610175366004611308565b610d87565b60606000805b6001600160a01b038416600090815260208190526040902054811015610226576001600160a01b038416600090815260208190526040812080546002929190849081106101cf576101cf6115ff565b906000526020600020906005020160040154815260200190815260200160002060030180546101fd90611615565b905060000361021457816102108161164f565b9250505b8061021e8161164f565b915050610180565b5060008167ffffffffffffffff8111156102425761024261149c565b60405190808252806020026020018201604052801561027b57816020015b6102686112be565b8152602001906001900390816102605790505b5090506000805b6001600160a01b0386166000908152602081905260409020548110156103c9576001600160a01b038616600090815260208190526040812080546002929190849081106102d1576102d16115ff565b906000526020600020906005020160040154815260200190815260200160002060030180546102ff90611615565b90506000036103b7576001600160a01b0386166000908152602081905260409020805482908110610332576103326115ff565b60009182526020918290206040805160a081018252600590930290910180546001600160a01b03908116845260018201541693830193909352600283015490820152600382015460608201526004909101546080820152835184908490811061039d5761039d6115ff565b602002602001018190525081806103b39061164f565b9250505b806103c18161164f565b915050610282565b5090949350505050565b60606000805b6001600160a01b03841660009081526020819052604090205481101561047e576001600160a01b03841660009081526020819052604081208054600291839185908110610428576104286115ff565b9060005260206000209060050201600401548152602001908152602001600020600301805461045690611615565b9050111561046c57816104688161164f565b9250505b806104768161164f565b9150506103d9565b5060008167ffffffffffffffff81111561049a5761049a61149c565b6040519080825280602002602001820160405280156104f557816020015b6040805160a08101825260608082526000602083018190529282018390528082015260808101919091528152602001906001900390816104b85790505b5090506000805b6001600160a01b0386166000908152602081905260409020548110156103c9576001600160a01b0386166000908152602081905260408120805483908110610546576105466115ff565b9060005260206000209060050201600401549050600060026000838152602001908152602001600020600301805461057d90611615565b905011156107125760008181526002602052604090819020815160a081019092528054829082906105ad90611615565b80601f01602080910402602001604051908101604052809291908181526020018280546105d990611615565b80156106265780601f106105fb57610100808354040283529160200191610626565b820191906000526020600020905b81548152906001019060200180831161060957829003601f168201915b505050918352505060018201546020820152600282015460ff16604082015260038201805460609092019161065a90611615565b80601f016020809104026020016040519081016040528092919081815260200182805461068690611615565b80156106d35780601f106106a8576101008083540402835291602001916106d3565b820191906000526020600020905b8154815290600101906020018083116106b657829003601f168201915b505050505081526020016004820154815250508484815181106106f8576106f86115ff565b6020026020010181905250828061070e9061164f565b9350505b508061071d8161164f565b9150506104fc565b600034116107895760405162461bcd60e51b815260206004820152602660248201527f5468652073656e7420616d6f756e74206d75737420626520677265617465722060448201526507468616e20360d41b60648201526084015b60405180910390fd5b6040516bffffffffffffffffffffffff1933606090811b8216602084015283901b16603482015234604882015242606882015260009060880160408051601f19818403018152918152815160209283012033600081815293849052919092209192506107f891908434856110d9565b6001600160a01b038216600090815260016020526040902061081d90338434856110d9565b6040516001600160a01b038316903480156108fc02916000818181858888f19350505050158015610852573d6000803e3d6000fd5b505050565b33600090815260208190526040902084906108729082611168565b6108ca5760405162461bcd60e51b8152602060048201526024808201527f5472616e73616374696f6e2073656e646572206973206e6f7420617574686f726044820152631a5e995960e21b6064820152608401610780565b3360009081526020819052604090205485906108f85760405162461bcd60e51b815260040161078090611676565b3360009081526020818152604080832080548251818502810185019093528083529192909190849084015b8282101561098f5760008481526020908190206040805160a0810182526005860290920180546001600160a01b03908116845260018083015490911684860152600282015492840192909252600381015460608401526004015460808301529083529092019101610923565b5050505090506000805b82518110156109e157838382815181106109b5576109b56115ff565b602002602001015160800151036109cf57600191506109e1565b806109d98161164f565b915050610999565b50806109ff5760405162461bcd60e51b8152600401610780906116bc565b60008881526002602052604090206003018054899190610a1e90611615565b159050610a825760405162461bcd60e51b815260206004820152602c60248201527f412072657669657720666f722074686973207472616e73616374696f6e20616c60448201526b72656164792065786973747360a01b6064820152608401610780565b603288511115610aee5760405162461bcd60e51b815260206004820152603160248201527f5469746c65206d757374206265206c657373207468616e206f7220657175616c60448201527020746f203530206368617261637465727360781b6064820152608401610780565b60018760ff1610158015610b06575060058760ff1611155b610b525760405162461bcd60e51b815260206004820152601e60248201527f526174696e67206d757374206265206265747765656e203120616e64203500006044820152606401610780565b6101f486511115610bbf5760405162461bcd60e51b815260206004820152603160248201527f54657874206d757374206265206c657373207468616e206f7220657175616c20604482015270746f20353030206368617261637465727360781b6064820152608401610780565b6040805160a0810182528981524260208083019190915260ff8a168284015260608201899052608082018c905260008c815260029091529190912081518291908190610c0b9082611767565b5060208201516001820155604082015160028201805460ff191660ff90921691909117905560608201516003820190610c449082611767565b506080820151816004015590505050505050505050505050565b610c666112be565b6001600160a01b0383166000908152602081905260409020610c889083611168565b610ccc5760405162461bcd60e51b8152602060048201526015602482015274151c985b9cd858dd1a5bdb881b9bdd08199bdd5b99605a1b6044820152606401610780565b6001600160a01b0383166000908152602081905260409020610cee90836111c5565b90505b92915050565b610cff6112be565b6001600160a01b0383166000908152600160205260409020610d219083611168565b610d655760405162461bcd60e51b8152602060048201526015602482015274151c985b9cd858dd1a5bdb881b9bdd08199bdd5b99605a1b6044820152606401610780565b6001600160a01b0383166000908152600160205260409020610cee90836111c5565b60606000805b6001600160a01b038416600090815260016020526040902054811015610e32576001600160a01b03841660009081526001602052604081208054600291839185908110610ddc57610ddc6115ff565b90600052602060002090600502016004015481526020019081526020016000206003018054610e0a90611615565b90501115610e205781610e1c8161164f565b9250505b80610e2a8161164f565b915050610d8d565b5060008167ffffffffffffffff811115610e4e57610e4e61149c565b604051908082528060200260200182016040528015610ea957816020015b6040805160a0810182526060808252600060208301819052928201839052808201526080810191909152815260200190600190039081610e6c5790505b5090506000805b6001600160a01b0386166000908152600160205260409020548110156103c9576001600160a01b0386166000908152600160205260408120805483908110610efa57610efa6115ff565b90600052602060002090600502016004015490506000600260008381526020019081526020016000206003018054610f3190611615565b905011156110c65760008181526002602052604090819020815160a08101909252805482908290610f6190611615565b80601f0160208091040260200160405190810160405280929190818152602001828054610f8d90611615565b8015610fda5780601f10610faf57610100808354040283529160200191610fda565b820191906000526020600020905b815481529060010190602001808311610fbd57829003601f168201915b505050918352505060018201546020820152600282015460ff16604082015260038201805460609092019161100e90611615565b80601f016020809104026020016040519081016040528092919081815260200182805461103a90611615565b80156110875780601f1061105c57610100808354040283529160200191611087565b820191906000526020600020905b81548152906001019060200180831161106a57829003601f168201915b505050505081526020016004820154815250508484815181106110ac576110ac6115ff565b602002602001018190525082806110c29061164f565b9350505b50806110d18161164f565b915050610eb0565b6040805160a0810182526001600160a01b0395861681529385166020808601918252918501938452426060860190815260808601938452875460018181018a556000998a52939098209551600590980290950180549787166001600160a01b03199889161781559051918101805492909616919096161790935551600284015551600383015551600490910155565b6000805b83548110156111bb5782848281548110611188576111886115ff565b906000526020600020906005020160040154036111a9576001915050610cf1565b806111b38161164f565b91505061116c565b5060009392505050565b6111cd6112be565b82546111eb5760405162461bcd60e51b815260040161078090611676565b60005b83548110156112a5578284828154811061120a5761120a6115ff565b9060005260206000209060050201600401540361129357838181548110611233576112336115ff565b60009182526020918290206040805160a081018252600590930290910180546001600160a01b039081168452600182015416938301939093526002830154908201526003820154606082015260049091015460808201529150610cf19050565b8061129d8161164f565b9150506111ee565b5060405162461bcd60e51b8152600401610780906116bc565b6040805160a08101825260008082526020820181905291810182905260608101829052608081019190915290565b80356001600160a01b038116811461130357600080fd5b919050565b60006020828403121561131a57600080fd5b610cee826112ec565b80516001600160a01b039081168352602080830151909116908301526040808201519083015260608082015190830152608090810151910152565b6020808252825182820181905260009190848201906040850190845b818110156113a05761138d838551611323565b9284019260a0929092019160010161137a565b50909695505050505050565b6000815180845260005b818110156113d2576020818501810151868301820152016113b6565b506000602082860101526020601f19601f83011685010191505092915050565b60006020808301818452808551808352604092508286019150828160051b87010184880160005b8381101561148e57603f19898403018552815160a0815181865261143f828701826113ac565b915050888201518986015260ff8883015116888601526060808301518683038288015261146c83826113ac565b6080948501519790940196909652505094870194925090860190600101611419565b509098975050505050505050565b634e487b7160e01b600052604160045260246000fd5b600082601f8301126114c357600080fd5b813567ffffffffffffffff808211156114de576114de61149c565b604051601f8301601f19908116603f011681019082821181831017156115065761150661149c565b8160405283815286602085880101111561151f57600080fd5b836020870160208301376000602085830101528094505050505092915050565b6000806000806080858703121561155557600080fd5b84359350602085013567ffffffffffffffff8082111561157457600080fd5b611580888389016114b2565b94506040870135915060ff8216821461159857600080fd5b909250606086013590808211156115ae57600080fd5b506115bb878288016114b2565b91505092959194509250565b600080604083850312156115da57600080fd5b6115e3836112ec565b946020939093013593505050565b60a08101610cf18284611323565b634e487b7160e01b600052603260045260246000fd5b600181811c9082168061162957607f821691505b60208210810361164957634e487b7160e01b600052602260045260246000fd5b50919050565b60006001820161166f57634e487b7160e01b600052601160045260246000fd5b5060010190565b60208082526026908201527f4e6f207472616e73616374696f6e7320666f756e6420666f722074686973206160408201526564647265737360d01b606082015260800190565b60208082526037908201527f4e6f207472616e73616374696f6e20666f756e6420776974682074686520676960408201527f76656e20494420666f7220746869732061646472657373000000000000000000606082015260800190565b601f82111561085257600081815260208120601f850160051c810160208610156117405750805b601f850160051c820191505b8181101561175f5782815560010161174c565b505050505050565b815167ffffffffffffffff8111156117815761178161149c565b6117958161178f8454611615565b84611719565b602080601f8311600181146117ca57600084156117b25750858301515b600019600386901b1c1916600185901b17855561175f565b600085815260208120601f198616915b828110156117f9578886015182559484019460019091019084016117da565b50858210156118175787850151600019600388901b60f8161c191681555b5050505050600190811b0190555056fea2646970667358221220aa958ef9f2c04f7e9d5692c59f4ecb67eb263c13d36d32dbd1bebf6c4e35d64264736f6c63430008130033";

    public static final String FUNC_ADDREVIEW = "addReview";

    public static final String FUNC_GETREVIEWSFORRECEIVER = "getReviewsForReceiver";

    public static final String FUNC_GETREVIEWSFORSENDER = "getReviewsForSender";

    public static final String FUNC_GETTRANSACTIONFORRECEIVER = "getTransactionForReceiver";

    public static final String FUNC_GETTRANSACTIONFORSENDER = "getTransactionForSender";

    public static final String FUNC_GETUNREVIEWEDTRANSACTIONS = "getUnreviewedTransactions";

    public static final String FUNC_SENDTRANSACTION = "sendTransaction";

    @Deprecated
    protected ReviewSystem(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ReviewSystem(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ReviewSystem(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ReviewSystem(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addReview(byte[] _transactionId, String _title, BigInteger _rating, String _text) {
        final Function function = new Function(
                FUNC_ADDREVIEW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_transactionId), 
                new org.web3j.abi.datatypes.Utf8String(_title), 
                new org.web3j.abi.datatypes.generated.Uint8(_rating), 
                new org.web3j.abi.datatypes.Utf8String(_text)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<List> getReviewsForReceiver(String _receiver) {
        final Function function = new Function(FUNC_GETREVIEWSFORRECEIVER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _receiver)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Review>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<List> getReviewsForSender(String _sender) {
        final Function function = new Function(FUNC_GETREVIEWSFORSENDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _sender)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Review>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<Transaction> getTransactionForReceiver(String _receiver, byte[] _transactionId) {
        final Function function = new Function(FUNC_GETTRANSACTIONFORRECEIVER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _receiver), 
                new org.web3j.abi.datatypes.generated.Bytes32(_transactionId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Transaction>() {}));
        return executeRemoteCallSingleValueReturn(function, Transaction.class);
    }

    public RemoteFunctionCall<Transaction> getTransactionForSender(String _sender, byte[] _transactionId) {
        final Function function = new Function(FUNC_GETTRANSACTIONFORSENDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _sender), 
                new org.web3j.abi.datatypes.generated.Bytes32(_transactionId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Transaction>() {}));
        return executeRemoteCallSingleValueReturn(function, Transaction.class);
    }

    public RemoteFunctionCall<List> getUnreviewedTransactions(String _addr) {
        final Function function = new Function(FUNC_GETUNREVIEWEDTRANSACTIONS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Transaction>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> sendTransaction(String _receiver, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_SENDTRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _receiver)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    @Deprecated
    public static ReviewSystem load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ReviewSystem(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ReviewSystem load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ReviewSystem(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ReviewSystem load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ReviewSystem(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ReviewSystem load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ReviewSystem(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ReviewSystem> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ReviewSystem.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ReviewSystem> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ReviewSystem.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ReviewSystem> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ReviewSystem.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ReviewSystem> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ReviewSystem.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class Review extends DynamicStruct {
        public String title;

        public BigInteger date;

        public BigInteger rating;

        public String text;

        public byte[] transactionId;

        public Review(String title, BigInteger date, BigInteger rating, String text, byte[] transactionId) {
            super(new org.web3j.abi.datatypes.Utf8String(title), 
                    new org.web3j.abi.datatypes.generated.Uint256(date), 
                    new org.web3j.abi.datatypes.generated.Uint8(rating), 
                    new org.web3j.abi.datatypes.Utf8String(text), 
                    new org.web3j.abi.datatypes.generated.Bytes32(transactionId));
            this.title = title;
            this.date = date;
            this.rating = rating;
            this.text = text;
            this.transactionId = transactionId;
        }

        public Review(Utf8String title, Uint256 date, Uint8 rating, Utf8String text, Bytes32 transactionId) {
            super(title, date, rating, text, transactionId);
            this.title = title.getValue();
            this.date = date.getValue();
            this.rating = rating.getValue();
            this.text = text.getValue();
            this.transactionId = transactionId.getValue();
        }
    }

    public static class Transaction extends StaticStruct {
        public String sender;

        public String receiver;

        public BigInteger amount;

        public BigInteger date;

        public byte[] id;

        public Transaction(String sender, String receiver, BigInteger amount, BigInteger date, byte[] id) {
            super(new org.web3j.abi.datatypes.Address(160, sender), 
                    new org.web3j.abi.datatypes.Address(160, receiver), 
                    new org.web3j.abi.datatypes.generated.Uint256(amount), 
                    new org.web3j.abi.datatypes.generated.Uint256(date), 
                    new org.web3j.abi.datatypes.generated.Bytes32(id));
            this.sender = sender;
            this.receiver = receiver;
            this.amount = amount;
            this.date = date;
            this.id = id;
        }

        public Transaction(Address sender, Address receiver, Uint256 amount, Uint256 date, Bytes32 id) {
            super(sender, receiver, amount, date, id);
            this.sender = sender.getValue();
            this.receiver = receiver.getValue();
            this.amount = amount.getValue();
            this.date = date.getValue();
            this.id = id.getValue();
        }
    }
}
