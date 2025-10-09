package com.areska.review;

import com.areska.review.dto.ReviewCreateRequest;
import com.areska.review.dto.ReviewResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
@Tag(name = "Reviews", description = "Operaciones relacionadas con reseñas de productos")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    @Operation(summary = "Crear una nueva reseña")
    public ResponseEntity<ReviewResponse> create(@RequestBody ReviewCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.create(request));
    }

    @GetMapping("/product/{productId}")
    @Operation(summary = "Obtener reseñas por producto")
    public ResponseEntity<List<ReviewResponse>> getByProduct(@PathVariable Integer productId) {
        List<ReviewResponse> reviews = reviewService.getByProduct(productId);
        if (reviews.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Obtener reseñas por usuario")
    public ResponseEntity<List<ReviewResponse>> getByUser(@PathVariable Integer userId) {
        List<ReviewResponse> reviews = reviewService.getByUser(userId);
        if (reviews.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reviews);
    }

    @DeleteMapping("/{reviewId}")
    @Operation(summary = "Eliminar una reseña por ID")
    public ResponseEntity<?> delete(@PathVariable Integer reviewId) {
        reviewService.deleteById(reviewId);
        return ResponseEntity.noContent().build();
    }
}
