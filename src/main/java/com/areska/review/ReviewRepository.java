package com.areska.review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

	List<Review> findByProduct_ProductId(Integer productId);

    List<Review> findByUser_UserId(Integer userId);
}
