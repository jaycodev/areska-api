package com.areska.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.areska.product.dto.response.ProductResponse;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Query("""
        SELECT 
            p.productId AS id,
            p.name AS name,
            p.description AS description,
            p.price AS price,
            p.stock AS stock,

            c.categoryId AS categoryId,
            c.name AS categoryName,

            p.createdAt AS createdAt
        FROM Product p
        JOIN p.category c
        ORDER BY p.id DESC
    """)
    List<ProductResponse> findList();

    @Query("""
        SELECT 
            p.productId AS id,
            p.name AS name,
            p.description AS description,
            p.price AS price,
            p.stock AS stock,

            c.categoryId AS categoryId,
            c.name AS categoryName,

            p.createdAt AS createdAt
        FROM Product p
        JOIN p.category c
        WHERE p.id = :id
    """)
    Optional<ProductResponse> findDetailById(Integer id);
}
