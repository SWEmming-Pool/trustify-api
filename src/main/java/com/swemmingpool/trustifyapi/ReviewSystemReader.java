package com.swemmingpool.trustifyapi;

import com.swemmingpool.trustifyapi.ReviewSystem.Review;
import org.bouncycastle.util.encoders.Hex;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ReadonlyTransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;

import java.util.ArrayList;
import java.util.Date;

import static java.util.Objects.requireNonNull;

@Service
public class ReviewSystemReader {
  private final static String ACCOUNT_ADDRESS = "0xe35d534EBe71555191CB3ce09D7accEE8663444E";
  private final static String CONTRACT_ADDRESS = "0x3297bc571f9420DcbD671bdFE98A48F07604B272";
  // Infura RPC node
  private final static Web3j CLIENT = Web3j.build(new HttpService("https://sepolia.infura.io/v3/2309bf77660544a0b78cef8a85d33a1f"));
  private final static ReadonlyTransactionManager MANAGER = new ReadonlyTransactionManager(CLIENT, ACCOUNT_ADDRESS);
  private final static DefaultGasProvider GAS_PROVIDER = new DefaultGasProvider();
  private static final ReviewSystem CONTRACT = ReviewSystem.load(CONTRACT_ADDRESS, CLIENT, MANAGER, GAS_PROVIDER);

  private JSONArray createJSONArray(ArrayList<Review> list) {
    JSONArray jsonReviews = new JSONArray();
    for(Review R : list) {
      JSONObject rev = new JSONObject();
      rev.put("transactionId", "0x"+ Hex.toHexString(R.transactionId));
      rev.put("title", R.title);
      rev.put("date", new Date(R.date.longValue()*1000));
      rev.put("rating", R.rating);
      rev.put("text", R.text);
      jsonReviews.add(rev);
    }
    return jsonReviews;
  }
  public JSONArray getReviewForAddress(String address, AddressType type) throws Exception {
    requireNonNull(address, "Address cannot be null");
    requireNonNull(type, "Address type cannot be null");

    if(!address.matches("^0x[a-fA-F0-9]{40}$")) {
      throw new IllegalArgumentException("Address is not a valid Ethereum address");
    }

    if(type!=AddressType.SENDER && type!=AddressType.RECEIVER) {
      throw new IllegalArgumentException("Address type is not valid");
    }

    ArrayList<Review> reviewArrayList;
    switch (type) {
      case SENDER -> {
        reviewArrayList = (ArrayList<Review>) CONTRACT.getReviewsForSender(address).sendAsync().get();
      }
      case RECEIVER -> {
        reviewArrayList = (ArrayList<Review>) CONTRACT.getReviewsForReceiver(address).sendAsync().get();
      }
      default -> throw new IllegalStateException("Unexpected address type: " + type);
    }

    return createJSONArray(reviewArrayList);
  }

}
