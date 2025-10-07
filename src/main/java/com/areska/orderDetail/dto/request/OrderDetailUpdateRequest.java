package com.areska.orderDetail.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailUpdateRequest {
    private Integer productId;
    private Integer quantity;
}