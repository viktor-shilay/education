package by.shilay.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class UserTasksKey implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "student_id")
    private Long studentId;
}
