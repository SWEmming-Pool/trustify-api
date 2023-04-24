package com.swemmingpool.trustifyapi;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.StaticStruct;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
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
    public static final String BINARY = "608060405234801561001057600080fd5b506114dc806100206000396000f3fe60806040526004361061004a5760003560e01c806316218c161461004f5780632bd123fe14610085578063381b8b5f1461009a57806366845b38146100ba578063869486b9146100e7575b600080fd5b34801561005b57600080fd5b5061006f61006a366004610f3f565b610114565b60405161007c9190610f95565b60405180910390f35b610098610093366004610f3f565b61038d565b005b3480156100a657600080fd5b506100986100b5366004611086565b61055b565b3480156100c657600080fd5b506100da6100d536600461110e565b6109a1565b60405161007c9190611138565b3480156100f357600080fd5b50610107610102366004610f3f565b610a58565b60405161007c919061118c565b60606000805b6001600160a01b0384166000908152602081905260409020548110156101c0576001600160a01b0384166000908152602081905260408120805460019291908490811061016957610169611236565b906000526020600020906005020160040154815260200190815260200160002060030180546101979061124c565b90506000036101ae57816101aa81611286565b9250505b806101b881611286565b91505061011a565b5060008167ffffffffffffffff8111156101dc576101dc610fe3565b60405190808252806020026020018201604052801561023557816020015b6040805160a0810182526000808252602080830182905292820181905260608201819052608082015282526000199092019101816101fa5790505b5090506000805b6001600160a01b038616600090815260208190526040902054811015610383576001600160a01b0386166000908152602081905260408120805460019291908490811061028b5761028b611236565b906000526020600020906005020160040154815260200190815260200160002060030180546102b99061124c565b9050600003610371576001600160a01b03861660009081526020819052604090208054829081106102ec576102ec611236565b60009182526020918290206040805160a081018252600590930290910180546001600160a01b03908116845260018201541693830193909352600283015490820152600382015460608201526004909101546080820152835184908490811061035757610357611236565b6020026020010181905250818061036d90611286565b9250505b8061037b81611286565b91505061023c565b5090949350505050565b600034116103f15760405162461bcd60e51b815260206004820152602660248201527f5468652073656e7420616d6f756e74206d75737420626520677265617465722060448201526507468616e20360d41b60648201526084015b60405180910390fd5b6040516bffffffffffffffffffffffff1933606090811b8216602084015283901b16603482015234604882015242606882015260009060880160408051808303601f19018152828252805160209182012033600081815280845284812060a0870186529186526001600160a01b0380891685880190815234968801968752426060890190815260808901868152855460018082018855968652979094209851600590970290980180546001600160a01b031990811697841697909717815590519381018054909616939091169290921790935592516002840155925160038301555160049091015590506040516001600160a01b038316903480156108fc02916000818181858888f19350505050158015610510573d6000803e3d6000fd5b5060408051348152602081018390526001600160a01b0384169133917ff2529500d69a37d599d4cffafd3aa14b04033ad4ec49915245b5c2806e6d5abb910160405180910390a35050565b33600090815260208190526040902084906105769082610daa565b6105ce5760405162461bcd60e51b8152602060048201526024808201527f5472616e73616374696f6e2073656e646572206973206e6f7420617574686f726044820152631a5e995960e21b60648201526084016103e8565b3360009081526020819052604090205485906105fc5760405162461bcd60e51b81526004016103e8906112ad565b3360009081526020818152604080832080548251818502810185019093528083529192909190849084015b828210156106935760008481526020908190206040805160a0810182526005860290920180546001600160a01b03908116845260018083015490911684860152600282015492840192909252600381015460608401526004015460808301529083529092019101610627565b5050505090506000805b82518110156106e557838382815181106106b9576106b9611236565b602002602001015160800151036106d357600191506106e5565b806106dd81611286565b91505061069d565b50806107035760405162461bcd60e51b81526004016103e8906112f3565b600088815260016020526040902060030180548991906107229061124c565b1590506107865760405162461bcd60e51b815260206004820152602c60248201527f412072657669657720666f722074686973207472616e73616374696f6e20616c60448201526b72656164792065786973747360a01b60648201526084016103e8565b6032885111156107f25760405162461bcd60e51b815260206004820152603160248201527f5469746c65206d757374206265206c657373207468616e206f7220657175616c60448201527020746f203530206368617261637465727360781b60648201526084016103e8565b60018760ff161015801561080a575060058760ff1611155b6108565760405162461bcd60e51b815260206004820152601e60248201527f526174696e67206d757374206265206265747765656e203120616e642035000060448201526064016103e8565b6101f4865111156108c35760405162461bcd60e51b815260206004820152603160248201527f54657874206d757374206265206c657373207468616e206f7220657175616c20604482015270746f20353030206368617261637465727360781b60648201526084016103e8565b6040805160a0810182528981524260208083019190915260ff8a168284015260608201899052608082018c905260008c81526001909152919091208151829190819061090f908261139f565b5060208201516001820155604082015160028201805460ff191660ff90921691909117905560608201516003820190610948908261139f565b50608082015181600401559050507f306dbe757eddc67adae3a19076c1fecd44047767cfaaf19c0e68e5348c8326dc89428a8a8e60405161098d95949392919061145f565b60405180910390a150505050505050505050565b6040805160a0810182526000808252602080830182905282840182905260608301829052608083018290526001600160a01b0386168252819052919091206109e99083610daa565b610a2d5760405162461bcd60e51b8152602060048201526015602482015274151c985b9cd858dd1a5bdb881b9bdd08199bdd5b99605a1b60448201526064016103e8565b6001600160a01b0383166000908152602081905260409020610a4f9083610e07565b90505b92915050565b60606000805b6001600160a01b038416600090815260208190526040902054811015610b03576001600160a01b03841660009081526020819052604081208054600191839185908110610aad57610aad611236565b90600052602060002090600502016004015481526020019081526020016000206003018054610adb9061124c565b90501115610af15781610aed81611286565b9250505b80610afb81611286565b915050610a5e565b5060008167ffffffffffffffff811115610b1f57610b1f610fe3565b604051908082528060200260200182016040528015610b7a57816020015b6040805160a0810182526060808252600060208301819052928201839052808201526080810191909152815260200190600190039081610b3d5790505b5090506000805b6001600160a01b038616600090815260208190526040902054811015610383576001600160a01b0386166000908152602081905260408120805483908110610bcb57610bcb611236565b90600052602060002090600502016004015490506000600160008381526020019081526020016000206003018054610c029061124c565b90501115610d975760008181526001602052604090819020815160a08101909252805482908290610c329061124c565b80601f0160208091040260200160405190810160405280929190818152602001828054610c5e9061124c565b8015610cab5780601f10610c8057610100808354040283529160200191610cab565b820191906000526020600020905b815481529060010190602001808311610c8e57829003601f168201915b505050918352505060018201546020820152600282015460ff166040820152600382018054606090920191610cdf9061124c565b80601f0160208091040260200160405190810160405280929190818152602001828054610d0b9061124c565b8015610d585780601f10610d2d57610100808354040283529160200191610d58565b820191906000526020600020905b815481529060010190602001808311610d3b57829003601f168201915b50505050508152602001600482015481525050848481518110610d7d57610d7d611236565b60200260200101819052508280610d9390611286565b9350505b5080610da281611286565b915050610b81565b6000805b8354811015610dfd5782848281548110610dca57610dca611236565b90600052602060002090600502016004015403610deb576001915050610a52565b80610df581611286565b915050610dae565b5060009392505050565b6040805160a0810182526000808252602082018190529181018290526060810182905260808101919091528254610e505760405162461bcd60e51b81526004016103e8906112ad565b60005b8354811015610f0a5782848281548110610e6f57610e6f611236565b90600052602060002090600502016004015403610ef857838181548110610e9857610e98611236565b60009182526020918290206040805160a081018252600590930290910180546001600160a01b039081168452600182015416938301939093526002830154908201526003820154606082015260049091015460808201529150610a529050565b80610f0281611286565b915050610e53565b5060405162461bcd60e51b81526004016103e8906112f3565b80356001600160a01b0381168114610f3a57600080fd5b919050565b600060208284031215610f5157600080fd5b610a4f82610f23565b80516001600160a01b039081168352602080830151909116908301526040808201519083015260608082015190830152608090810151910152565b6020808252825182820181905260009190848201906040850190845b81811015610fd757610fc4838551610f5a565b9284019260a09290920191600101610fb1565b50909695505050505050565b634e487b7160e01b600052604160045260246000fd5b600082601f83011261100a57600080fd5b813567ffffffffffffffff8082111561102557611025610fe3565b604051601f8301601f19908116603f0116810190828211818310171561104d5761104d610fe3565b8160405283815286602085880101111561106657600080fd5b836020870160208301376000602085830101528094505050505092915050565b6000806000806080858703121561109c57600080fd5b84359350602085013567ffffffffffffffff808211156110bb57600080fd5b6110c788838901610ff9565b94506040870135915060ff821682146110df57600080fd5b909250606086013590808211156110f557600080fd5b5061110287828801610ff9565b91505092959194509250565b6000806040838503121561112157600080fd5b61112a83610f23565b946020939093013593505050565b60a08101610a528284610f5a565b6000815180845260005b8181101561116c57602081850181015186830182015201611150565b506000602082860101526020601f19601f83011685010191505092915050565b60006020808301818452808551808352604092508286019150828160051b87010184880160005b8381101561122857603f19898403018552815160a081518186526111d982870182611146565b915050888201518986015260ff888301511688860152606080830151868303828801526112068382611146565b60809485015197909401969096525050948701949250908601906001016111b3565b509098975050505050505050565b634e487b7160e01b600052603260045260246000fd5b600181811c9082168061126057607f821691505b60208210810361128057634e487b7160e01b600052602260045260246000fd5b50919050565b6000600182016112a657634e487b7160e01b600052601160045260246000fd5b5060010190565b60208082526026908201527f4e6f207472616e73616374696f6e7320666f756e6420666f722074686973206160408201526564647265737360d01b606082015260800190565b60208082526037908201527f4e6f207472616e73616374696f6e20666f756e6420776974682074686520676960408201527f76656e20494420666f7220746869732061646472657373000000000000000000606082015260800190565b601f82111561139a57600081815260208120601f850160051c810160208610156113775750805b601f850160051c820191505b8181101561139657828155600101611383565b5050505b505050565b815167ffffffffffffffff8111156113b9576113b9610fe3565b6113cd816113c7845461124c565b84611350565b602080601f83116001811461140257600084156113ea5750858301515b600019600386901b1c1916600185901b178555611396565b600085815260208120601f198616915b8281101561143157888601518255948401946001909101908401611412565b508582101561144f5787850151600019600388901b60f8161c191681555b5050505050600190811b01905550565b60a08152600061147260a0830188611146565b86602084015260ff8616604084015282810360608401526114938186611146565b915050826080830152969550505050505056fea26469706673582212202c05aec9b3f59135a16ae604f0831eea6be3ae1a7e0fc6543083456f57e1763b64736f6c63430008130033";

    public static final String FUNC_ADDREVIEW = "addReview";

    public static final String FUNC_GETREVIEWSFORADDRESS = "getReviewsForAddress";

    public static final String FUNC_GETTRANSACTION = "getTransaction";

    public static final String FUNC_GETUNREVIEWEDTRANSACTIONS = "getUnreviewedTransactions";

    public static final String FUNC_SENDTRANSACTION = "sendTransaction";

    public static final Event REVIEWADDED_EVENT = new Event("ReviewAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint8>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}));
    ;

    public static final Event TRANSACTIONSENT_EVENT = new Event("TransactionSent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Bytes32>() {}));
    ;

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

//    public static List<ReviewAddedEventResponse> getReviewAddedEvents(TransactionReceipt transactionReceipt) {
//        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(REVIEWADDED_EVENT, transactionReceipt);
//        ArrayList<ReviewAddedEventResponse> responses = new ArrayList<ReviewAddedEventResponse>(valueList.size());
//        for (Contract.EventValuesWithLog eventValues : valueList) {
//            ReviewAddedEventResponse typedResponse = new ReviewAddedEventResponse();
//            typedResponse.log = eventValues.getLog();
//            typedResponse.title = (String) eventValues.getNonIndexedValues().get(0).getValue();
//            typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
//            typedResponse.rating = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
//            typedResponse.text = (String) eventValues.getNonIndexedValues().get(3).getValue();
//            typedResponse.id = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
//            responses.add(typedResponse);
//        }
//        return responses;
//    }

    public Flowable<ReviewAddedEventResponse> reviewAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ReviewAddedEventResponse>() {
            @Override
            public ReviewAddedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(REVIEWADDED_EVENT, log);
                ReviewAddedEventResponse typedResponse = new ReviewAddedEventResponse();
                typedResponse.log = log;
                typedResponse.title = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.rating = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.text = (String) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.id = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReviewAddedEventResponse> reviewAddedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REVIEWADDED_EVENT));
        return reviewAddedEventFlowable(filter);
    }

//    public static List<TransactionSentEventResponse> getTransactionSentEvents(TransactionReceipt transactionReceipt) {
//        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(TRANSACTIONSENT_EVENT, transactionReceipt);
//        ArrayList<TransactionSentEventResponse> responses = new ArrayList<TransactionSentEventResponse>(valueList.size());
//        for (Contract.EventValuesWithLog eventValues : valueList) {
//            TransactionSentEventResponse typedResponse = new TransactionSentEventResponse();
//            typedResponse.log = eventValues.getLog();
//            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
//            typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
//            typedResponse._amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
//            typedResponse._id = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
//            responses.add(typedResponse);
//        }
//        return responses;
//    }

    public Flowable<TransactionSentEventResponse> transactionSentEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, TransactionSentEventResponse>() {
            @Override
            public TransactionSentEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSACTIONSENT_EVENT, log);
                TransactionSentEventResponse typedResponse = new TransactionSentEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._id = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransactionSentEventResponse> transactionSentEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSACTIONSENT_EVENT));
        return transactionSentEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addReview(byte[] _transactionId, String _title, BigInteger _rating, String _text) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDREVIEW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_transactionId), 
                new org.web3j.abi.datatypes.Utf8String(_title), 
                new org.web3j.abi.datatypes.generated.Uint8(_rating), 
                new org.web3j.abi.datatypes.Utf8String(_text)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<List> getReviewsForAddress(String _address) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETREVIEWSFORADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _address)), 
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

    public RemoteFunctionCall<Transaction> getTransaction(String _address, byte[] _id) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETTRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _address), 
                new org.web3j.abi.datatypes.generated.Bytes32(_id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Transaction>() {}));
        return executeRemoteCallSingleValueReturn(function, Transaction.class);
    }

    public RemoteFunctionCall<List> getUnreviewedTransactions(String _address) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETUNREVIEWEDTRANSACTIONS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _address)), 
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
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
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

    public static class ReviewAddedEventResponse extends BaseEventResponse {
        public String title;

        public BigInteger timestamp;

        public BigInteger rating;

        public String text;

        public byte[] id;
    }

    public static class TransactionSentEventResponse extends BaseEventResponse {
        public String _from;

        public String _to;

        public BigInteger _amount;

        public byte[] _id;
    }
}
