package by.shilay.app.model.requestDto;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String group;
    private String email;
    private String password;
}
