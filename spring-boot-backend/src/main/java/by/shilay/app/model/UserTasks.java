package by.shilay.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "users_tasks")
public class UserTasks {

    @EmbeddedId
    private UserTasksKey id;

    @Column(name = "grade")
    private String grade;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("taskId")
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private User student;

}
