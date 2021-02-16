package by.shilay.app.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDto {
    private Long id;
    private String taskName;
    private LocalDate creationDate;
    private LocalDate updateDate;
    private LocalDate dueDate;
    private String description;
    private String materialName;
    private String grade;
    private Long userId;
}
