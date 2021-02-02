package by.shilay.app.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Review {
    private Long id;
    private String reviewStatus;
    private LocalDate reviewDate;
    private String review;
}
