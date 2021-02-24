package by.shilay.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Review> reviews;

    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<UserTasks> usersTasks;

}
