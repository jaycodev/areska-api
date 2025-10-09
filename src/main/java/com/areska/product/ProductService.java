package com.areska.product;

import com.areska.category.CategoryService;
import com.areska.product.dto.request.ProductRequest;
import com.areska.product.dto.response.ProductResponse;
import com.areska.shared.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository productRepository;

    private final CategoryService categoryService;

    public List<ProductResponse> getList() {
        return productRepository.findList();
    }

    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    public ProductResponse getDetailById(Integer id) {
        return productRepository.findDetailById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));
    }

    @Transactional
    public ProductResponse create(ProductRequest request) {
        Product product = new Product();
        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setStock(request.stock());

        product.setCategory(categoryService.findById(request.categoryId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Category not found with ID: " + request.categoryId())));

        Product saved = productRepository.save(product);

        return toResponse(saved);
    }

    @Transactional
    public ProductResponse update(Integer id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));

        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setStock(request.stock());

        product.setCategory(categoryService.findById(request.categoryId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Category not found with ID: " + request.categoryId())));

        Product updated = productRepository.save(product);

        return toResponse(updated);
    }

    private ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getCategory().getCategoryId(),
                product.getCategory().getName(),
                product.getCreatedAt());
    }
}
