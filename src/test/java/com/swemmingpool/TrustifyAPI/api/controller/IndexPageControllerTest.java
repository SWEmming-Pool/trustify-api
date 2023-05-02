package com.swemmingpool.TrustifyAPI.api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IndexPageControllerTest {

  private IndexPageController indexPageController;

  @BeforeEach
  public void setUp() {
    indexPageController = new IndexPageController();
  }

  @Test
  public void index() {
    assertEquals(
        "<h1>Trustify</h1><h2>Authentic and Verifiable Reviews Platform</h2>",
        indexPageController.index()
    );
  }
}