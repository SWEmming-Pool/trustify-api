package com.swemmingpool.TrustifyAPI.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexPageController{

    @RequestMapping("/")
    public String index() {
      return "<h1>Trustify</h1><h2>Authentic and Verifiable Reviews Platform</h2>";
    }
}
