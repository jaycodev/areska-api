package com.areska.review;

import com.areska.product.Product;
import com.areska.product.ProductRepository;
import com.areska.review.dto.ReviewCreateRequest;
import com.areska.review.dto.ReviewResponse;
import com.areska.user.User;
import com.areska.user.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Transactional
    public ReviewResponse create(ReviewCreateRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

        Review review = Review.builder()
                .user(user)
                .product(product)
                .rating(request.getRating())
                .comment(request.getComment())
                .reviewDate(LocalDateTime.now())
                .build();

        return toResponse(reviewRepository.save(review));
    }

    public List<ReviewResponse> getByProduct(Integer productId) {
        return reviewRepository.findByProduct_ProductId(productId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public List<ReviewResponse> getByUser(Integer userId) {
        return reviewRepository.findByUser_UserId(userId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional
    public void deleteById(Integer reviewId) {
        if (!reviewRepository.existsById(reviewId)) {
            throw new EntityNotFoundException("Review no encontrada");
        }
        reviewRepository.deleteById(reviewId);
    }

    private ReviewResponse toResponse(Review review) {
        return new ReviewResponse(
                review.getReviewId(),
                review.getUser().getUserId(),
                review.getProduct().getProductId(),
                review.getProduct().getName(),
                review.getRating(),
                review.getComment(),
                review.getReviewDate()
        );
    }
}
