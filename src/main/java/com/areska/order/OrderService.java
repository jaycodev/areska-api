package com.areska.order;

import com.areska.order.dto.request.OrderCreateRequest;
import com.areska.order.dto.request.OrderUpdateRequest;
import com.areska.order.dto.response.OrderDetailResponse;
import com.areska.order.dto.response.OrderResponse;
import com.areska.orderDetail.OrderDetail;
import com.areska.orderDetail.OrderDetailRepository;
import com.areska.product.Product;
import com.areska.product.ProductRepository;
import com.areska.shared.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductRepository productRepository;
//  private final UserRepository userRepository;

    public List<OrderResponse> getList() {
        return ((List<Order>) orderRepository.findAll())
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public OrderResponse getDetailById(Integer id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with ID: " + id));
        return toResponse(order);
    }

    @Transactional
    public OrderResponse create(OrderCreateRequest req) {
    	
//    	if (!userRepository.existsById(req.getUserId())) {
//          throw new ResourceNotFoundException("User not found with ID: " + req.getUserId());
//      }
    	
    	Order order = orderRepository.save(Order.builder()
                .userId(req.getUserId())
                .status("pending")
                .pickupMethod(req.getPickupMethod() == null ? "store" : req.getPickupMethod())
                .total(BigDecimal.ZERO)
                .build());

        if (req.getItems() == null || req.getItems().isEmpty()) {
            return toResponse(order);
        }

        List<OrderDetail> details = req.getItems().stream().map(it -> {
            if (it.getQuantity() == null || it.getQuantity() <= 0)
                throw new IllegalArgumentException("Quantity must be >= 1 for productId=" + it.getProductId());

            Product p = productRepository.findById(it.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + it.getProductId()));

            if (p.getStock() != null && p.getStock() < it.getQuantity())
                throw new IllegalArgumentException("Not enough stock for product " + p.getProductId());

            if (p.getStock() != null) { 
            	p.setStock(p.getStock() - it.getQuantity());
            	productRepository.save(p);
            }

            return OrderDetail.builder()
                    .order(order)
                    .product(p)
                    .quantity(it.getQuantity())
                    .unitPrice(p.getPrice())
                    .build();
        }).toList();

        orderDetailRepository.saveAll(details);

        order.setTotal(details.stream()
                .map(d -> d.getUnitPrice().multiply(BigDecimal.valueOf(d.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        orderRepository.save(order);

        return toResponse(order, details);
    }

    @Transactional
    public OrderResponse update(Integer id, OrderUpdateRequest req) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with ID: " + id));

        if (req.getStatus() != null && !req.getStatus().isBlank()) order.setStatus(req.getStatus());
        return toResponse(orderRepository.save(order));
    }

    @Transactional
    public void recalcTotal(Integer orderId) {
        Order o = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with ID: " + orderId));
        o.setTotal(orderDetailRepository.findByOrder_OrderId(orderId).stream()
                .map(d -> d.getUnitPrice().multiply(BigDecimal.valueOf(d.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        orderRepository.save(o);
    }

    private OrderResponse toResponse(Order o) {
        List<OrderDetail> details = orderDetailRepository.findByOrder_OrderId(o.getOrderId());
        return toResponse(o, details);
    }

    private OrderResponse toResponse(Order o, List<OrderDetail> details) {
        List<OrderDetailResponse> items = details.stream().map(d ->
                new OrderDetailResponse(
                        d.getDetailId(),
                        o.getOrderId(),
                        d.getProduct().getProductId(),
                        d.getProduct().getName(),
                        d.getQuantity(),
                        d.getUnitPrice(),
                        d.getUnitPrice().multiply(BigDecimal.valueOf(d.getQuantity()))
                )
        ).toList();

        return new OrderResponse(
                o.getOrderId(),
                o.getUserId(),
                o.getOrderDate(),
                o.getStatus(),
                o.getTotal(),
                o.getPickupMethod(),
                items
        );
    }
}
