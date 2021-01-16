package by.shilay.app.model;

import lombok.Data;

@Data
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean isBlocked;
    private Role role;

}
