package com.areska.payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.areska.order.Order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

	@ManyToOne(fetch = FetchType.LAZY)
 	@JoinColumn(name = "order_id", nullable = false)
 	private Order order;
    
    @Column(nullable = false, name = "method")
    private String method;

    @Column(nullable = false, name = "amount")
    private BigDecimal amount;
    
    @CreationTimestamp
    @Column(name = "payment_date", insertable = false, updatable = false)
    private LocalDateTime paymentDate;
    
}
