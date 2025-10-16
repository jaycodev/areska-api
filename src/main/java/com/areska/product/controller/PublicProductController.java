package com.areska.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.areska.product.ProductService;
import com.areska.product.dto.request.ProductRequest;
import com.areska.product.dto.response.ProductAdminResponse;
import com.areska.product.dto.response.ProductPublicResponse;
import com.areska.shared.api.ApiSuccess;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/public/products")
@RequiredArgsConstructor
@Tag(name = "Products", description = "Operations related to products")
public class PublicProductController {
    private final ProductService productPublicService;

    @GetMapping
    @Operation(summary = "List all products")
    public ResponseEntity<ApiSuccess<List<ProductPublicResponse>>> list() {
        List<ProductPublicResponse> products = productPublicService.getPublicList();
        ApiSuccess<List<ProductPublicResponse>> response = new ApiSuccess<>(
                products.isEmpty() ? "No products found" : "Products listed successfully",
                products);

        HttpStatus status = products.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return ResponseEntity.status(status).body(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a product by ID")
    public ResponseEntity<ApiSuccess<ProductAdminResponse>> get(@PathVariable Integer id) {
        ProductAdminResponse product = productPublicService.getDetailById(id);
        return ResponseEntity.ok(new ApiSuccess<>("Product found", product));
    }

    @PostMapping
    @Operation(summary = "Create a new product")
    public ResponseEntity<ApiSuccess<ProductAdminResponse>> create(@Valid @RequestBody ProductRequest request) {
        ProductAdminResponse created = productPublicService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiSuccess<>("Product created successfully", created));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a product by ID")
    public ResponseEntity<ApiSuccess<ProductAdminResponse>> update(@PathVariable Integer id,
            @Valid @RequestBody ProductRequest request) {
        ProductAdminResponse updated = productPublicService.update(id, request);
        return ResponseEntity.ok(new ApiSuccess<>("Product updated successfully", updated));
    }
}
