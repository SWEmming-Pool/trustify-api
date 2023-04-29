package com.swemmingpool.TrustifyAPI.api.model;

import java.util.Date;

public record ReviewDTO(String title, Date date, int rating, String text, String transactionId) {

}