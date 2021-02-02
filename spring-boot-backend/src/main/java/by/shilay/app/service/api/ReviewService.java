package by.shilay.app.service.api;

import by.shilay.app.dto.ReviewDto;
import by.shilay.app.model.Review;

import java.util.List;


public interface ReviewService {
    Review create(Review review);
    List<ReviewDto> getAllByReviewer(Long id);
    List<ReviewDto> getAllByMaterialId(Long id);
}
