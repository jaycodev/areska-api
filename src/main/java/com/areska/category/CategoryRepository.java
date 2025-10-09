package com.areska.category;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.areska.category.dto.response.CategoryResponse;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    @Query("""
        SELECT 
            c.categoryId AS id,
            c.name AS name,
            c.description AS description
        FROM Category c
        ORDER BY c.id DESC
    """)
    List<CategoryResponse> findList();

    @Query("""
        SELECT 
            c.categoryId AS id,
            c.name AS name,
            c.description AS description
        FROM Category c
        WHERE c.id = :id
    """)
    Optional<CategoryResponse> findDetailById(Integer id);
}
