package com.swemmingpool.TrustifyAPI.api.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ReviewDTOTest {

  private ReviewDTO reviewDTO;
  @BeforeEach
  public void setUp() {
    reviewDTO = new ReviewDTO(
        "title",
        Date.from(Instant.now()),
        5,
        "text",
        "transactionId"
    );
  }

  @AfterEach
  public void tearDown() {
    reviewDTO = null;
  }

  @Test
  public void title() {
    assertEquals("title", reviewDTO.title());
  }

  @Test
  public void date() {
    assertEquals(Date.from(Instant.now()), reviewDTO.date());
  }

  @Test
  public void rating() {
    assertEquals(5, reviewDTO.rating());
  }

  @Test
  public void text() {
    assertEquals("text", reviewDTO.text());
  }

  @Test
  public void transactionId() {
    assertEquals("transactionId", reviewDTO.transactionId());
  }
}