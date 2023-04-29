package com.swemmingpool.TrustifyAPI.api.controller;

import com.swemmingpool.TrustifyAPI.api.model.Mapper;
import com.swemmingpool.TrustifyAPI.api.model.ReviewDTO;
import com.swemmingpool.TrustifyAPI.api.service.ReviewSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
public class ReviewSystemController {

  private final ReviewSystemService reviewSystemService;
  private final Mapper mapper;

  @Autowired
  public ReviewSystemController(ReviewSystemService reviewSystemService, Mapper mapper) {
    this.reviewSystemService = reviewSystemService;
    this.mapper = mapper;
  }

  @GetMapping("/reviews/{address}")
  public List<ReviewDTO> getReviewsByReceiver(@PathVariable String address)
      throws ExecutionException, InterruptedException {
    return (List<ReviewDTO>) reviewSystemService.getReviewsByReceiver(address)
        .stream()
        .map(mapper::mapToDTO)
        .collect(Collectors.toList());
  }

  @GetMapping("/reviews/sender/{address}")
  public List<ReviewDTO> getReviewsBySender(@PathVariable String address)
      throws ExecutionException, InterruptedException {
    return (List<ReviewDTO>) reviewSystemService.getReviewsBySender(address)
        .stream()
        .map(mapper::mapToDTO)
        .collect(Collectors.toList());
  }
}
