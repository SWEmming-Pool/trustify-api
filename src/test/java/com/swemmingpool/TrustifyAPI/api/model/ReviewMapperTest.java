package com.swemmingpool.TrustifyAPI.api.model;

import com.swemmingpool.TrustifyAPI.api.model.ReviewSystem.Review;
import org.bouncycastle.util.encoders.Hex;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ReviewMapperTest {

  private ReviewMapper reviewMapper;
  private Review review;

  @BeforeEach
  void setUp() {
    reviewMapper = new ReviewMapper();
    review = new Review(
        "title",
        BigInteger.valueOf(1),
        BigInteger.valueOf(5),
        "text",
        "9221a3c91029530abac06f454be1ef53".getBytes()
    );
  }

  @AfterEach
  void tearDown() {
    reviewMapper = null;
    review = null;
  }

  @Test
  public void mapToDTO() {
    ReviewDTO reviewDTO = reviewMapper.mapToDTO(review);
    assertEquals(reviewDTO.title(), review.title);
    assertEquals(reviewDTO.date(), new Date(review.date.longValue()*1000));
    assertEquals(reviewDTO.rating(), review.rating.intValue());
    assertEquals(reviewDTO.text(), review.text);
    assertEquals(reviewDTO.transactionId(), "0x" + Hex.toHexString(review.transactionId));
  }
}