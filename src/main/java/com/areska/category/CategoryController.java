package com.areska.category;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.areska.category.dto.request.CategoryRequest;
import com.areska.category.dto.response.CategoryResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@Tag(name = "Categories", description = "Operations related to categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    @Operation(summary = "List all categories")
    public ResponseEntity<?> list() {
        List<CategoryResponse> categories = categoryService.getList();
        if (categories.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a category by ID")
    public ResponseEntity<CategoryResponse> get(@PathVariable Integer id) {
        CategoryResponse category = categoryService.getDetailById(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping
    @Operation(summary = "Create a new category")
    public ResponseEntity<?> create(@RequestBody CategoryRequest request) {
        CategoryResponse created = categoryService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a category by ID")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody CategoryRequest request) {
        CategoryResponse updated = categoryService.update(id, request);
        return ResponseEntity.ok(updated);
    }
}
