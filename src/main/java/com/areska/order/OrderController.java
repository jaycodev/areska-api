package com.areska.order;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.areska.order.dto.request.OrderCreateRequest;
import com.areska.order.dto.request.OrderUpdateRequest;
import com.areska.order.dto.response.OrderResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Tag(name = "Orders", description = "Operations related to orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    @Operation(summary = "List all orders")
    public ResponseEntity<?> list() {
        List<OrderResponse> orders = orderService.getList();
        if (orders.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an order by ID (with items)")
    public ResponseEntity<OrderResponse> get(@PathVariable Integer id) {
        OrderResponse order = orderService.getDetailById(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping
    @Operation(summary = "Create a new order")
    public ResponseEntity<?> create(@RequestBody OrderCreateRequest request) {
        OrderResponse created = orderService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an order status method")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody OrderUpdateRequest request) {
        OrderResponse updated = orderService.update(id, request);
        return ResponseEntity.ok(updated);
    }
}