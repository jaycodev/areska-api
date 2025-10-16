package com.areska.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.areska.product.dto.response.ProductPublicResponse;
import com.areska.product.dto.response.ProductAdminResponse;
import com.areska.product.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Query("""
        SELECT 
            p.id AS id,
            p.name AS name,
            p.price AS price,
            p.originalPrice AS originalPrice,
            p.mainImage AS mainImage,
            p.badge AS badge,

            c.id AS categoryId,
            c.name AS categoryName,

            p.createdAt AS createdAt
        FROM Product p
        JOIN p.category c
        ORDER BY p.id DESC
    """)
    List<ProductPublicResponse> findPublicList();

    @Query("""
        SELECT 
            p.id AS id,
            p.name AS name,
            p.description AS description,
            p.price AS price,
            p.stock AS stock,

            c.id AS categoryId,
            c.name AS categoryName,

            p.createdAt AS createdAt
        FROM Product p
        JOIN p.category c
        ORDER BY p.id DESC
    """)
    List<ProductAdminResponse> findAdminList();

    @Query("""
        SELECT 
            p.id AS id,
            p.name AS name,
            p.description AS description,
            p.price AS price,
            p.stock AS stock,

            c.id AS categoryId,
            c.name AS categoryName,

            p.createdAt AS createdAt
        FROM Product p
        JOIN p.category c
        WHERE p.id = :id
    """)
    Optional<ProductAdminResponse> findDetailById(Integer id);
}
