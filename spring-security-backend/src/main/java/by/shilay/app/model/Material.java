package by.shilay.app.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Material {
    private Long id;
    private String materialName;
    private LocalDate creationDate;
    private String type;
    private String description;
    private Long author;
    private String discipline;
}
