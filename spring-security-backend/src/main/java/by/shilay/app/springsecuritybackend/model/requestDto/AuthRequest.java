package by.shilay.app.springsecuritybackend.model.requestDto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
