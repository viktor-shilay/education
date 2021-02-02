package by.shilay.app.model.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
}
