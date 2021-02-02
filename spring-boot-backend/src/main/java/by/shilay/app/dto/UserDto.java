package by.shilay.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String group;
    private String email;
    private String password;
    private boolean isBlocked;
}
