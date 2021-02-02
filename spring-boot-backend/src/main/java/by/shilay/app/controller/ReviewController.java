package by.shilay.app.controller;

import by.shilay.app.dto.ReviewDto;
import by.shilay.app.model.Review;
import by.shilay.app.service.api.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/material/{id}")
    public ResponseEntity<List<ReviewDto>> getAllByMaterial(@PathVariable("id") Long id){
        try{
            return new ResponseEntity<>(reviewService.getAllByMaterialId(id), HttpStatus.OK);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }

    @GetMapping("/reviewer/{id}")
    public ResponseEntity<List<ReviewDto>> getAllByReviewer(@PathVariable("id") Long id){
        try{
            return new ResponseEntity<>(reviewService.getAllByReviewer(id), HttpStatus.OK);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }

    @PostMapping
    public ResponseEntity<Review> create(@RequestBody Review review){
        try{
            return new ResponseEntity<>(reviewService.create(review), HttpStatus.OK);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }
}
