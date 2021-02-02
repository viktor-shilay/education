package by.shilay.app.model;

import lombok.Data;

@Data
public class Discipline {
    private Long id;
    private String name;
    private String shortName;
    private String description;
    private Long userId;
}
