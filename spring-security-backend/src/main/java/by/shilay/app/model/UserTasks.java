package by.shilay.app.model;

import lombok.Data;

@Data
public class UserTasks {
    private String grade;
    private String status;
    private Long userId;
    private Long taskId;
    private Long studentId;
}
