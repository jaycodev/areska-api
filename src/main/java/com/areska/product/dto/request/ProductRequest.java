package com.areska.product.dto.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private Integer categoryId;
}
