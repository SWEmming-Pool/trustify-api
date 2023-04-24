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

@Service
public class ReviewSystemReader {
  private final static String ACCOUNT_ADDRESS = "0xe35d534EBe71555191CB3ce09D7accEE8663444E";
  private final static String CONTRACT_ADDRESS = "0xbc7477568E2EB68390f7791B3231b12F969af155";
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
  public JSONArray getReviewForAddress(String address) throws Exception{
    var reviewArray = (ArrayList<Review>) CONTRACT.getReviewsForAddress(address).sendAsync().get();
    return createJSONArray(reviewArray);
  }
}
