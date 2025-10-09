package com.areska.orderDetail.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailRequest {
	@NotNull(message = "Order ID is required")
	@Positive(message = "Order ID must be a positive number")
    private Integer orderId;
	
	@NotNull(message = "Product ID is required")
	@Positive(message = "Product ID must be a positive number")
    private Integer productId;
    
	@NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;
}