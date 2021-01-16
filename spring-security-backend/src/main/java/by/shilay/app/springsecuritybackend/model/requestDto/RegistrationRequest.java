package by.shilay.app.springsecuritybackend.model.requestDto;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
