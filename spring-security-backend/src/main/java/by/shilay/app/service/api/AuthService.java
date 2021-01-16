package by.shilay.app.service.api;

import by.shilay.app.model.requestDto.AuthRequest;
import by.shilay.app.model.requestDto.RegistrationRequest;
import by.shilay.app.model.responseDto.AuthResponse;

public interface AuthService {
    AuthResponse login(AuthRequest authRequest);

    void register(RegistrationRequest registrationRequest);
}
