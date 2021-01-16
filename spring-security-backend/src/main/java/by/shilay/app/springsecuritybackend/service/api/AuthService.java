package by.shilay.app.springsecuritybackend.service.api;

import by.shilay.app.springsecuritybackend.model.requestDto.AuthRequest;
import by.shilay.app.springsecuritybackend.model.requestDto.RegistrationRequest;
import by.shilay.app.springsecuritybackend.model.responseDto.AuthResponse;

public interface AuthService {
    AuthResponse login(AuthRequest authRequest);

    void register(RegistrationRequest registrationRequest);
}
