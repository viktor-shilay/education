package by.shilay.app.service.impl;

import by.shilay.app.dto.ReviewDto;
import by.shilay.app.model.Review;
import by.shilay.app.repository.ReviewRepository;
import by.shilay.app.service.api.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<ReviewDto> getAllByReviewer(Long id) {
        return transferToListDto(reviewRepository.findAllByUserId(id));
    }

    @Override
    public List<ReviewDto> getAllByMaterialId(Long id) {
        return transferToListDto(reviewRepository.findAllByMaterialId(id));
    }

    private ReviewDto transferToReviewDto(Review review){
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setReviewStatus(review.getReviewStatus());
        reviewDto.setReviewDate(review.getReviewDate());
        reviewDto.setReview(review.getReview());
        return reviewDto;
    }

    private List<ReviewDto> transferToListDto(List<Review> reviews){
        List<ReviewDto> reviewDtos = new ArrayList<>();
        for(Review review: reviews){
            reviewDtos.add(transferToReviewDto(review));
        }
        return reviewDtos;
    }
}
