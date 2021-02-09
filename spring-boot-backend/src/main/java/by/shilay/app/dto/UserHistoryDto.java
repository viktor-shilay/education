package by.shilay.app.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserHistoryDto {
    private Long id;
    private LocalDate date;
    private String reason;
    private Long targetUser;
}
