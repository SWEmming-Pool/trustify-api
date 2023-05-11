package com.swemmingpool.TrustifyAPI.api.service;

import com.swemmingpool.TrustifyAPI.api.model.ReviewSystem;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.swemmingpool.TrustifyAPI.api.model.ReviewSystem.Review;
import static com.swemmingpool.TrustifyAPI.api.model.ReviewSystem.load;
import static java.util.Objects.requireNonNull;

@Service
public class ReviewSystemService {
  private final ReviewSystem contract;

  @Autowired
  public ReviewSystemService(ReviewSystem contract) {
    this.contract = contract;
  }

  public List getReviewsByReceiver(String address) throws ExecutionException, InterruptedException, NullPointerException {
    requireNonNull(address);

    if(!address.matches("^0x[a-fA-F0-9]{40}$")) {
      throw new IllegalArgumentException("This is not a valid Ethereum address");
    } else {
      return contract.getReviewsByReceiver(address).sendAsync().get();
    }

  }

  public List getReviewsBySender(String address) throws ExecutionException, InterruptedException {
    requireNonNull(address);

    if(!address.matches("^0x[a-fA-F0-9]{40}$")) {
      throw new IllegalArgumentException("This is not a valid Ethereum address");
    } else {
      return contract.getReviewsBySender(address).sendAsync().get();
    }

  }

  public Review getReviewById(String id) throws ExecutionException, InterruptedException {
    requireNonNull(id);

    if(!id.matches("^0x[A-Fa-f0-9]{64}$")) {
      throw new IllegalArgumentException("This is not a valid transaction id");
    } else {
      return contract.getReviewById(Hex.decode(id.substring(2))).sendAsync().get();
    }
  }

}
