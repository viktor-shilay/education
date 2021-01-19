package by.shilay.app.service.impl;

import by.shilay.app.model.requestDto.AuthRequest;
import by.shilay.app.model.requestDto.RegistrationRequest;
import by.shilay.app.model.responseDto.AuthResponse;
import by.shilay.app.config.URLConstants;
import by.shilay.app.model.User;
import by.shilay.app.security.jwt.JwtTokenProvider;
import by.shilay.app.service.api.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthServiceImpl implements AuthService {

    private final RestTemplate restTemplate;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(RestTemplate restTemplate, AuthenticationManager authenticationManager,
                           JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder) {
        this.restTemplate = restTemplate;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthResponse login(AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(),
                        authRequest.getPassword()
                )
        );
        String token = jwtTokenProvider.generateJwtToken(authentication);
        User user = restTemplate.getForObject(URLConstants.USERS_URL + "/email/" + authRequest.getEmail(), User.class);
        return new AuthResponse(token, user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole().getRole());
    }

    @Override
    public void register(RegistrationRequest registrationRequest) {
        String hashPassword = passwordEncoder.encode(registrationRequest.getPassword());
        User user = new User();
        user.setFirstName(registrationRequest.getFirstName());
        user.setLastName(registrationRequest.getLastName());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(hashPassword);
        restTemplate.postForEntity(URLConstants.USERS_URL, user, User.class);
    }
}
