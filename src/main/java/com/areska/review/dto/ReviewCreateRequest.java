package com.areska.review.dto;

import lombok.Data;

@Data
public class ReviewCreateRequest {
    private Integer userId;
    private Integer productId;
    private Integer rating;
    private String comment;
}
