package by.shilay.app.dto;

import lombok.Data;

@Data
public class UserTasksDto {
    private String grade;
    private String status;
    private Long userId;
    private Long taskId;
    private Long studentId;
}
