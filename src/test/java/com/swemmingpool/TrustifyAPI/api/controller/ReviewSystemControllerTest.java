package com.swemmingpool.TrustifyAPI.api.controller;

import com.swemmingpool.TrustifyAPI.api.model.ReviewDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReviewSystemControllerTest {

  private ReviewSystemController reviewSystemController;

  private static List<ReviewDTO> reviewList;

  @BeforeAll
  public static void setUpAll() {
    reviewList = List.of(
      new ReviewDTO(
          "first",
          Date.from(Instant.ofEpochSecond(1)),
          1,
          "start",
          "firstId"
      ),
      new ReviewDTO(
          "second",
          Date.from(Instant.ofEpochSecond(1)),
          5,
          "end",
          "secondId"
      )
    );

  }

  @BeforeEach
  public void setUp() throws ExecutionException, InterruptedException {
    reviewSystemController = Mockito.mock(ReviewSystemController.class);
    when(reviewSystemController.getReviewsByReceiver(Mockito.anyString())).thenReturn(reviewList);
    when(reviewSystemController.getReviewsBySender(Mockito.anyString())).thenReturn(reviewList);
    when(reviewSystemController.getReviewById(Mockito.anyString())).thenReturn(reviewList.get(0));
  }

  @Test
  public void getReviewsByReceiver() throws ExecutionException, InterruptedException {
    assertEquals(reviewList, reviewSystemController.getReviewsByReceiver("receiver"));
  }

  @Test
  public void getReviewsBySender() throws ExecutionException, InterruptedException {
    assertEquals(reviewList, reviewSystemController.getReviewsBySender("sender"));
  }

  @Test
  public void getReviewById() throws ExecutionException, InterruptedException {
    assertEquals(reviewList.get(0), reviewSystemController.getReviewById("id"));
  }
}