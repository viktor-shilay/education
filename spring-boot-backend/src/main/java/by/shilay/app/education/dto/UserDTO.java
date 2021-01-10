package by.shilay.app.education.dto;

import by.shilay.app.education.model.Role;
import by.shilay.app.education.model.UserGroup;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private UserGroup userGroup;
}
