package com.swemmingpool.trustifyapi;

import org.json.simple.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrustifyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrustifyApiApplication.class, args);
		var jsonarray = new JSONArray();
		System.out.println(jsonarray.size());

	}

}
