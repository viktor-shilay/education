package by.shilay.app.model;

import lombok.Data;

import java.util.Date;

@Data
public class Task {

    private Long id;
    private String taskName;
    private Date creationDate;
    private Date updateDate;
    private Date dueDate;
    private String description;

}
