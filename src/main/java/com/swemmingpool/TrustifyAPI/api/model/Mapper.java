package com.swemmingpool.TrustifyAPI.api.model;

import com.swemmingpool.TrustifyAPI.api.model.ReviewSystem.Review;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Mapper {

  public ReviewDTO mapToDTO(Review review) {
    String title = review.title;
    Date date = new Date(review.date.longValue()*1000);
    int rating = review.rating.intValue();
    String text = review.text;
    String transactionId = "0x" + Hex.toHexString(review.transactionId);
    return new ReviewDTO(title, date, rating, text, transactionId);
  }

  public Object mapToDTO(Object o) {
    return mapToDTO((Review) o);
  }

}
