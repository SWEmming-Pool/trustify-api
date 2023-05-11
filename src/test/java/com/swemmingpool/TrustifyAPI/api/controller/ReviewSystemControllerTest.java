package com.swemmingpool.TrustifyAPI.api.controller;

import com.swemmingpool.TrustifyAPI.api.model.ReviewDTO;
import com.swemmingpool.TrustifyAPI.api.model.ReviewMapper;
import com.swemmingpool.TrustifyAPI.api.service.ReviewSystemService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReviewSystemControllerTest {

  @Autowired
  private ReviewSystemService reviewSystemService;
  @Autowired
  private ReviewMapper reviewMapper;

  private ReviewSystemController mockController;
  private static List<ReviewDTO> reviewList;

  private static ReviewSystemController normalController;

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
    mockController = Mockito.mock(ReviewSystemController.class);
    when(mockController.getReviewsByReceiver(Mockito.anyString())).thenReturn(reviewList);
    when(mockController.getReviewsBySender(Mockito.anyString())).thenReturn(reviewList);
    when(mockController.getReviewById(Mockito.anyString())).thenReturn(reviewList.get(0));

    normalController = new ReviewSystemController(reviewSystemService, reviewMapper);

  }

  @Test
  public void getReviewsByReceiver() throws ExecutionException, InterruptedException {
    assertEquals(reviewList, mockController.getReviewsByReceiver("receiver"));
  }

  @Test
  public void getReviewsBySender() throws ExecutionException, InterruptedException {
    assertEquals(reviewList, mockController.getReviewsBySender("sender"));
  }

  @Test
  public void getReviewById() throws ExecutionException, InterruptedException {
    assertEquals(reviewList.get(0), mockController.getReviewById("id"));
  }

  @Test
  public void getReviewsByReceiverOnZeroAddress() throws ExecutionException, InterruptedException {
    assertEquals(
        List.of(),
        normalController.getReviewsByReceiver("0x0000000000000000000000000000000000000000")
    );
  }

  @Test
  public void getReviewsBySenderOnZeroAddress() throws ExecutionException, InterruptedException {
    assertEquals(
        List.of(),
        normalController.getReviewsBySender("0x0000000000000000000000000000000000000000")
    );
  }

  @Test
  public void getReviewByIdOnZeroId() throws ExecutionException, InterruptedException {
    assertEquals(
        "",
        normalController.getReviewById("0x0000000000000000000000000000000000000000000000000000000000000000").title()
    );
  }
}