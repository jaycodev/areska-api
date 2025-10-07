package com.areska.order.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class OrderCreateRequest {
	private Integer userId;
	private String pickupMethod;
	private List<OrderItemRequest> items;
}
