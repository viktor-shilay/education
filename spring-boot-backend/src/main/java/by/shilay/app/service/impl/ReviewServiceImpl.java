package by.shilay.app.service.impl;

import by.shilay.app.model.Review;
import by.shilay.app.repository.ReviewRepository;
import by.shilay.app.service.api.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
}
