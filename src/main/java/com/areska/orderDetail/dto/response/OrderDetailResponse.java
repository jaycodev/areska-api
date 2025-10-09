package com.areska.orderDetail.dto.response;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "orderId", "product", "quantity", "unitPrice", "lineTotal" })
public record OrderDetailResponse(
        Integer id,
        Integer orderId,

        @JsonIgnore Integer productId,
        @JsonIgnore String  productName,

        Integer quantity,
        BigDecimal unitPrice,
        BigDecimal lineTotal)
{

    @JsonGetter("product")
    public Map<String, Object> getProduct() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", productId());
        map.put("name", productName());
        return map;
    }
}
