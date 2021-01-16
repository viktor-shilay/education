package by.shilay.app.model.requestDto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
