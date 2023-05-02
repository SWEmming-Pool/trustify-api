package com.swemmingpool.TrustifyAPI.api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomErrorControllerTest {

  private CustomErrorController customErrorController;

  @BeforeEach
  public void setUp() {
    customErrorController = new CustomErrorController();
  }

  @Test
  public void handleError() {
    assertEquals(
        "An error occurred",
        customErrorController.handleError()
    );
  }
}