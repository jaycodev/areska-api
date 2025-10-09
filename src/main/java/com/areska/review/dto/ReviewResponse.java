package com.areska.review.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ReviewResponse {
    private Integer reviewId;
    private Integer userId;
    private Integer productId;
    private String productName;
    private Integer rating;
    private String comment;
    private LocalDateTime reviewDate;
}
