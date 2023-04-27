package com.swemmingpool.trustifyapi;

import com.swemmingpool.trustifyapi.ReviewSystem.Review;
import org.bouncycastle.util.encoders.Hex;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ReviewSystemReaderTest {

  private ReviewSystemReader nullListReader;
  private ReviewSystemReader emptyListReader;
  private ReviewSystemReader normalListReader;

  private static JSONArray validList;
  private static JSONArray emptyList;

  private static JSONArray nullList;

  @BeforeClass
  public static void classSetUp() {
    var reviewList = List.of(
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
                .getBytes())
    );

    nullList = null;
    emptyList = new JSONArray();
    validList = new JSONArray();

    for(var R : reviewList) {
      JSONObject rev = new JSONObject();
      rev.put("transactionId", "0x"+ Hex.toHexString(R.transactionId));
      rev.put("title", R.title);
      rev.put("date", new Date(R.date.longValue()*1000));
      rev.put("rating", R.rating);
      rev.put("text", R.text);
      validList.add(rev);
    }
  }

  @Before
  public void setUp() throws Exception {

    nullListReader = Mockito.mock(ReviewSystemReader.class);
    when(nullListReader.getReviewForAddress(Mockito.anyString(), Mockito.any(AddressType.class)))
        .thenReturn(nullList);

    emptyListReader = Mockito.mock(ReviewSystemReader.class);
    when(emptyListReader.getReviewForAddress(Mockito.anyString(), Mockito.any(AddressType.class)))
        .thenReturn(emptyList);

    normalListReader = Mockito.mock(ReviewSystemReader.class);
    when(normalListReader.getReviewForAddress(Mockito.anyString(), Mockito.any(AddressType.class)))
        .thenReturn(validList);
  }


  @Test
  public void testGetReviewForNullReceiverAddress() {

    normalListReader = new ReviewSystemReader();

    NullPointerException exc = assertThrows(
        NullPointerException.class,
        () -> normalListReader.getReviewForAddress(null, AddressType.RECEIVER)
    );

    assertEquals("Address cannot be null", exc.getMessage());

  }

  @Test
  public void testGetReviewForNullSenderAddress() {

    normalListReader = new ReviewSystemReader();

    NullPointerException exc = assertThrows(
        NullPointerException.class,
        () -> normalListReader.getReviewForAddress(null, AddressType.SENDER)
    );

    assertEquals("Address cannot be null", exc.getMessage());

  }

  @Test
  public void testGetReviewForNullAddressType() {

    normalListReader = new ReviewSystemReader();

    NullPointerException exc = assertThrows(
        NullPointerException.class,
        () -> normalListReader.getReviewForAddress("0xe35d534EBe71555191CB3ce09D7accEE8663444E", null)
    );

    assertEquals("Address type cannot be null", exc.getMessage());

  }

  @Test
  public void testGetReviewForInvalidReceiverAddress() {

    normalListReader = new ReviewSystemReader();

    IllegalArgumentException exc = assertThrows(
        IllegalArgumentException.class,
        () -> normalListReader.getReviewForAddress("abc", AddressType.RECEIVER)
    );

    assertEquals("Address is not a valid Ethereum address", exc.getMessage());

  }

  @Test
  public void testGetReviewForInvalidSenderAddress() {

    normalListReader = new ReviewSystemReader();

    IllegalArgumentException exc = assertThrows(
        IllegalArgumentException.class,
        () -> normalListReader.getReviewForAddress("xyz", AddressType.SENDER)
    );

    assertEquals("Address is not a valid Ethereum address", exc.getMessage());

  }

  @Test
  public void testGetReviewForAddressOnReceiverNullList() throws Exception {
    JSONArray reviewForAddress = nullListReader.getReviewForAddress(
        "0xe35d534EBe71555191CB3ce09D7accEE8663444E",
        AddressType.RECEIVER);

    assertNull(reviewForAddress);
  }

  @Test
  public void testGetReviewForAddressOnSenderNullList() throws Exception {
    JSONArray reviewForAddress = nullListReader.getReviewForAddress(
        "0xe35d534EBe71555191CB3ce09D7accEE8663444E",
        AddressType.SENDER);

    assertNull(reviewForAddress);
  }

  @Test
  public void testGetReviewForAddressOnReceiverEmptyList() throws Exception {
    JSONArray reviewForAddress = emptyListReader.getReviewForAddress(
        "0xe35d534EBe71555191CB3ce09D7accEE8663444E",
        AddressType.RECEIVER);

    assertThat(reviewForAddress.isEmpty()).isTrue();
  }

  @Test
  public void testGetReviewForAddressOnSenderEmptyList() throws Exception {
    JSONArray reviewForAddress = emptyListReader.getReviewForAddress(
        "0xe35d534EBe71555191CB3ce09D7accEE8663444E",
        AddressType.SENDER);

    assertThat(reviewForAddress.isEmpty()).isTrue();
  }


}