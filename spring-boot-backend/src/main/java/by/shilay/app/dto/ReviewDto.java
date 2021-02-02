package by.shilay.app.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReviewDto {
    private Long id;
    private String reviewStatus;
    private LocalDate reviewDate;
    private String review;
}
