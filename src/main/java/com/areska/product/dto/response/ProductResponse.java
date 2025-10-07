package com.areska.product.dto.response;

import java.util.LinkedHashMap;
import java.util.Map;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "name", "description", "price", "stock", "category", "createdAt" })
public record ProductResponse(
        Integer id,
        String name,
        String description,
        BigDecimal price,
        Integer stock,

        @JsonIgnore Integer categoryId,
        @JsonIgnore String categoryName,

        LocalDateTime createdAt) {

    @JsonGetter("category")
    public Map<String, Object> getCategory() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", categoryId());
        map.put("name", categoryName());
        return map;
    }
}
