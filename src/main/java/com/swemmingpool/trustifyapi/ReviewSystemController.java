package com.swemmingpool.trustifyapi;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewSystemController {

  private final ReviewSystemReader reviewSystemReader;

  @Autowired
  public ReviewSystemController(ReviewSystemReader reviewSystemReader) {
    this.reviewSystemReader = reviewSystemReader;
  }

  @GetMapping(value = "/reviews/{address}")
  public JSONArray getReviewForAddress(@PathVariable String address) throws Exception {
    return reviewSystemReader.getReviewForAddress(address);
  }
}
