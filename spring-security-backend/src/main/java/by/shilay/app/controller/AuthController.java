package by.shilay.app.controller;

import by.shilay.app.model.requestDto.RegistrationRequest;
import by.shilay.app.model.responseDto.AuthResponse;
import by.shilay.app.model.requestDto.AuthRequest;
import by.shilay.app.service.api.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        AuthResponse authResponse = authService.login(authRequest);
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<HttpStatus> register(@RequestBody RegistrationRequest registrationRequest) {
        authService.register(registrationRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
