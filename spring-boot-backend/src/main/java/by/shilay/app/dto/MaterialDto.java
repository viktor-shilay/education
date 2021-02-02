package by.shilay.app.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MaterialDto {
    private Long id;
    private String materialName;
    private LocalDate creationDate;
    private String type;
    private String description;
}
