package com.areska.payment;

import com.areska.order.Order;
import com.areska.order.OrderRepository;
import com.areska.payment.dto.PaymentCreateRequest;
import com.areska.payment.dto.PaymentResponse;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

     
    @Transactional
    public PaymentResponse create(PaymentCreateRequest req) {
        Order order = orderRepository.findById(req.getOrderId())
                .orElseThrow(() -> new EntityNotFoundException("Orden no encontrada con ID: " + req.getOrderId()));


        if (order.getTotal().compareTo(req.getAmount()) != 0) {
            throw new IllegalArgumentException("El monto del pago no coincide con el total de la orden.");
        }

        Payment payment = Payment.builder().order(order).method(req.getMethod()).amount(req.getAmount()).build();

        return toResponse(paymentRepository.save(payment));
    }
    
    @Transactional(readOnly = true)
    public List<PaymentResponse> getAll() {
        return paymentRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }
    
    public List<PaymentResponse> getByOrderId(Integer orderId) {
        List<Payment> payments = paymentRepository.findAllByOrder_Id(orderId);
        
        if (payments.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron pagos para la orden ID: " + orderId);
        }
        return payments.stream()
                .map(this::toResponse)
                .toList();
    }
 
    @Transactional
    public void deleteById(Integer paymentId) {
        if (!paymentRepository.existsById(paymentId)) {
            throw new EntityNotFoundException("Pago no encontrado con ID: " + paymentId);
        }
        paymentRepository.deleteById(paymentId);
             
    }

    private PaymentResponse toResponse(Payment p) {
        return new PaymentResponse(
                p.getId(),
                p.getOrder().getId(),
                p.getMethod(),
                p.getAmount(),
                p.getPaymentDate()
        );
    }
}
