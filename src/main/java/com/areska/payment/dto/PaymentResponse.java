package com.areska.payment.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentResponse {

    private Integer paymentId;
    private Integer orderId;
    private String method;
    private BigDecimal amount;
    private LocalDateTime paymentDate;
}
