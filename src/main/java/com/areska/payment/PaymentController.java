package com.areska.payment;

import com.areska.payment.dto.PaymentCreateRequest;
import com.areska.payment.dto.PaymentResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
@Tag(name = "Payments", description = "Operaciones relacionadas con pagos")
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    @Operation(summary = "Listar todos los pagos")
    public ResponseEntity<?> listAllPayments() {
        List<PaymentResponse> payments = paymentService.getAll();
        if (payments.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/{orderId}")
    @Operation(summary = "Obtener el pago por ID de la orden")
    public ResponseEntity<List<PaymentResponse>> getByOrderId(@PathVariable Integer orderId) {
        List<PaymentResponse> payments = paymentService.getByOrderId(orderId);
        return ResponseEntity.ok(payments);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo pago para una orden")
    public ResponseEntity<?> createPayment(@RequestBody PaymentCreateRequest request) {
        PaymentResponse created = paymentService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{paymentId}")
    @Operation(summary = "Eliminar un pago por su ID")
    public ResponseEntity<?> deletePayment(@PathVariable Integer paymentId) {
        paymentService.deleteById(paymentId);
        return ResponseEntity.noContent().build();
    }
}
