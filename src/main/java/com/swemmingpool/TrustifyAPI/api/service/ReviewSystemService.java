package com.swemmingpool.TrustifyAPI.api.service;

import com.swemmingpool.TrustifyAPI.api.model.ReviewSystem;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ReadonlyTransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.swemmingpool.TrustifyAPI.api.model.ReviewSystem.Review;
import static com.swemmingpool.TrustifyAPI.api.model.ReviewSystem.load;

@Service
public class ReviewSystemService {

  private final String ACCOUNT_ADDRESS = "0xe35d534EBe71555191CB3ce09D7accEE8663444E";
  private final String CONTRACT_ADDRESS = "0x748E332b507968EdBfFE429F95BBF7D621a9a835";
  private final String INFURA_NODE = "https://sepolia.infura.io/v3/2309bf77660544a0b78cef8a85d33a1f";
  private final Web3j CLIENT = Web3j.build(new HttpService(INFURA_NODE));
  private final ReadonlyTransactionManager TRANSACTION_MANAGER = new ReadonlyTransactionManager(CLIENT, ACCOUNT_ADDRESS);
  private final DefaultGasProvider GAS_PROVIDER = new DefaultGasProvider();
  private final ReviewSystem CONTRACT = load(CONTRACT_ADDRESS, CLIENT, TRANSACTION_MANAGER, GAS_PROVIDER);


  public List getReviewsByReceiver(String address) throws ExecutionException, InterruptedException {
    return CONTRACT.getReviewsByReceiver(address).sendAsync().get();
  }

  public List getReviewsBySender(String address) throws ExecutionException, InterruptedException {
    return CONTRACT.getReviewsBySender(address).sendAsync().get();
  }

  public Review getReviewById(String id) throws ExecutionException, InterruptedException {
    return CONTRACT.getReviewById(Hex.decode(id.substring(2))).sendAsync().get();
  }

}
