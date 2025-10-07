package com.areska.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.areska.product.dto.request.ProductRequest;
import com.areska.product.dto.response.ProductResponse;
import com.areska.shared.api.ApiSuccess;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "Products", description = "Operations related to products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @Operation(summary = "List all products")
    public ResponseEntity<ApiSuccess<List<ProductResponse>>> list() {
        List<ProductResponse> products = productService.getList();
        ApiSuccess<List<ProductResponse>> response = new ApiSuccess<>(
                products.isEmpty() ? "No products found" : "Products listed successfully",
                products);

        HttpStatus status = products.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return ResponseEntity.status(status).body(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a product by ID")
    public ResponseEntity<ApiSuccess<ProductResponse>> get(@PathVariable Integer id) {
        ProductResponse product = productService.getDetailById(id);
        return ResponseEntity.ok(new ApiSuccess<>("Product found", product));
    }

    @PostMapping
    @Operation(summary = "Create a new product")
    public ResponseEntity<ApiSuccess<ProductResponse>> create(@Valid @RequestBody ProductRequest request) {
        ProductResponse created = productService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiSuccess<>("Product created successfully", created));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a product by ID")
    public ResponseEntity<ApiSuccess<ProductResponse>> update(@PathVariable Integer id,
            @Valid @RequestBody ProductRequest request) {
        ProductResponse updated = productService.update(id, request);
        return ResponseEntity.ok(new ApiSuccess<>("Product updated successfully", updated));
    }
}
