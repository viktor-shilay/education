package by.shilay.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DisciplineDto {
    private Long id;
    private String name;
    private String shortName;
    private String description;
    private Long userId;
}
