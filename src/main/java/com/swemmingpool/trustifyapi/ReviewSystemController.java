package com.swemmingpool.trustifyapi;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewSystemController {

  private final ReviewSystemReader reviewSystemReader;

  @Autowired
  public ReviewSystemController(ReviewSystemReader reviewSystemReader) {
    this.reviewSystemReader = reviewSystemReader;
  }

  @RequestMapping("/")
  public @ResponseBody String index() {
    return "Trustify API";
  }

  @GetMapping(value = "/reviews/{address}")
  public JSONArray getReviewsForReceiver(@PathVariable String address) throws Exception {
    return reviewSystemReader.getReviewForAddress(address, AddressType.RECEIVER);
  }

  @GetMapping(value = "/reviews/sender/{address}")
  public JSONArray getReviewsBySender(@PathVariable String address) throws Exception {
    return reviewSystemReader.getReviewForAddress(address, AddressType.SENDER);
  }
}