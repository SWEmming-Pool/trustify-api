package com.swemmingpool.TrustifyAPI.api.service;

import com.swemmingpool.TrustifyAPI.api.model.ReviewSystem.Review;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReviewSystemServiceTest {

  private static List validList;
  private static List emptyList;

  private ReviewSystemService validListService;
  private ReviewSystemService emptyListService;

  private ReviewSystemService normalService;

  @BeforeAll
  public static void setUpAll() {
    validList = List.of(
        new Review(
            "First",
            BigInteger.valueOf(
                new Date(2021, 1, 1).getTime()
            ),
            BigInteger.valueOf(1),
            "Futuristic",
            "9221a3c91029530abac06f454be1ef53"
                .getBytes()),
        new Review(
            "Second",
            BigInteger.valueOf(
                new Date(2022, 2, 2).getTime()
            ),
            BigInteger.valueOf(2),
            "Bombastic",
            "053bfb4183534a779157fb55cb6b2ea7"
                .getBytes()),
        new Review(
            "Third",
            BigInteger.valueOf(
                new Date(2023, 3, 3).getTime()
            ),
            BigInteger.valueOf(3),
            "Enormous",
            "5c2d4dce3eb6b9a99b02dea01f32aa9e"
                .getBytes()),
        new Review(
            "Fourth",
            BigInteger.valueOf(
                new Date(2024, 4, 4).getTime()
            ),
            BigInteger.valueOf(4),
            "Universal",
            "79e5174d7da48ee6bde8fa0386f2608a"
                .getBytes()),
        new Review(
            "Fifth",
            BigInteger.valueOf(
                new Date(2025, 5, 5).getTime()
            ),
            BigInteger.valueOf(5),
            "Abracadabra",
            "e9849d8affb0379ca003376c3fe58e03"
                .getBytes()
        )
    );

    emptyList = List.of();
  }

  @BeforeEach
  public void setUp() throws ExecutionException, InterruptedException {
    emptyListService = Mockito.mock(ReviewSystemService.class);
    when(emptyListService.getReviewsByReceiver("0x0")).thenReturn(emptyList);
    when(emptyListService.getReviewsBySender("0x0")).thenReturn(emptyList);
    when(emptyListService.getReviewById("0x0")).thenReturn(null);

    validListService = Mockito.mock(ReviewSystemService.class);
    when(validListService.getReviewsByReceiver("0x0")).thenReturn(validList);
    when(validListService.getReviewsBySender("0x0")).thenReturn(validList);
    when(validListService.getReviewById("0x0")).thenReturn((Review) validList.get(0));

    normalService = new ReviewSystemService();
  }

  @AfterEach
  public void tearDown() {
    emptyListService = null;
    validListService = null;
  }

  @Test
  public void getReviewsByReceiverOnNullAddress() {
    assertThrows(NullPointerException.class, () -> {
      normalService.getReviewsByReceiver(null);
    });
  }

  @Test
  public void getReviewsBySenderOnNullAddress() {
    assertThrows(NullPointerException.class, () -> {
      normalService.getReviewsBySender(null);
    });
  }

  @Test
  public void getReviewByIdOnNullId() {
    assertThrows(NullPointerException.class, () -> {
      normalService.getReviewById(null);
    });
  }

  @Test
  public void getReviewsByReceiverOnInvalidAddress() {
    assertThrows(IllegalArgumentException.class, () -> {
      normalService.getReviewsByReceiver("invalid");
    });
  }

  @Test
  public void getReviewsBySenderOnInvalidAddress() {
    assertThrows(IllegalArgumentException.class, () -> {
      normalService.getReviewsBySender("invalid");
    });
  }

  @Test
  public void getReviewByIdOnInvalidId() {
    assertThrows(IllegalArgumentException.class, () -> {
      normalService.getReviewById("invalid");
    });
  }

  @Test
  public void getReviewsByReceiverOnEmptyList() throws ExecutionException, InterruptedException {
    assertEquals(emptyListService.getReviewsByReceiver("0x0").size(), 0);
  }

  @Test
  public void getReviewsBySenderOnEmptyList() throws ExecutionException, InterruptedException {
    assertEquals(emptyListService.getReviewsBySender("0x0").size(), 0);
  }

  @Test
  public void getReviewByIdOnEmptyList() throws ExecutionException, InterruptedException {
    assertNull(emptyListService.getReviewById("0x0"));
  }

  @Test
  public void getReviewsByReceiverOnValidAddress() throws ExecutionException, InterruptedException {
    assertEquals(validListService.getReviewsByReceiver("0x0").size(), 5);
  }

  @Test
  public void getReviewsBySenderOnValidAddress() throws ExecutionException, InterruptedException {
    assertEquals(validListService.getReviewsBySender("0x0").size(), 5);
  }

  @Test
  public void getReviewByIdOnValidId() throws ExecutionException, InterruptedException {
    assertEquals(validListService.getReviewById("0x0"), validList.get(0));
  }

}