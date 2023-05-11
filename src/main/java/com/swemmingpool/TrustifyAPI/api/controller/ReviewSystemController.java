package com.swemmingpool.TrustifyAPI.api.controller;

import com.swemmingpool.TrustifyAPI.api.model.ReviewMapper;
import com.swemmingpool.TrustifyAPI.api.model.ReviewDTO;
import com.swemmingpool.TrustifyAPI.api.service.ReviewSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
public class ReviewSystemController {

  private final ReviewSystemService reviewSystemService;
  private final ReviewMapper reviewMapper;

  @Autowired
  public ReviewSystemController(ReviewSystemService reviewSystemService, ReviewMapper reviewMapper) {
    this.reviewSystemService = reviewSystemService;
    this.reviewMapper = reviewMapper;
  }

  @SuppressWarnings("unchecked")
  @GetMapping("/reviews/{address}")
  public List<ReviewDTO> getReviewsByReceiver(@PathVariable String address)
      throws ExecutionException, InterruptedException {
    return (List<ReviewDTO>) reviewSystemService.getReviewsByReceiver(address)
        .stream()
        .map(reviewMapper::mapToDTO)
        .collect(Collectors.toList());
  }

  @SuppressWarnings("unchecked")
  @GetMapping("/reviews/sender/{address}")
  public List<ReviewDTO> getReviewsBySender(@PathVariable String address)
      throws ExecutionException, InterruptedException {
    return (List<ReviewDTO>) reviewSystemService.getReviewsBySender(address)
        .stream()
        .map(reviewMapper::mapToDTO)
        .collect(Collectors.toList());
  }

  @GetMapping("/review/{id}")
  public ReviewDTO getReviewById(@PathVariable String id)
      throws ExecutionException, InterruptedException {
    return reviewMapper.mapToDTO(reviewSystemService.getReviewById(id));
  }
}
