package com.areska.category;

import com.areska.category.dto.request.CategoryRequest;
import com.areska.category.dto.response.CategoryResponse;
import com.areska.shared.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryResponse> getList() {
        return categoryRepository.findList();
    }

    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }

    public CategoryResponse getDetailById(Integer id) {
        return categoryRepository.findDetailById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + id));
    }

    @Transactional
    public CategoryResponse create(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.name());
        category.setDescription(request.description());

        Category saved = categoryRepository.save(category);

        return toResponse(saved);
    }

    @Transactional
    public CategoryResponse update(Integer id, CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + id));

        category.setName(request.name());
        category.setDescription(request.description());

        Category updated = categoryRepository.save(category);

        return toResponse(updated);
    }

    private CategoryResponse toResponse(Category category) {
        return new CategoryResponse(
                category.getCategoryId(),
                category.getName(),
                category.getDescription());
    }
}
