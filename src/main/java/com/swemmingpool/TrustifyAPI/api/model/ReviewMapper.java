package com.swemmingpool.TrustifyAPI.api.model;

import com.swemmingpool.TrustifyAPI.api.model.ReviewSystem.Review;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ReviewMapper {

  public ReviewDTO mapToDTO(Object object) {
    Review review = (Review) object;
    String title = review.title;
    Date date = new Date(review.date.longValue()*1000);
    int rating = review.rating.intValue();
    String text = review.text;
    String transactionId = "0x" + Hex.toHexString(review.transactionId);
    return new ReviewDTO(title, date, rating, text, transactionId);
  }


}
