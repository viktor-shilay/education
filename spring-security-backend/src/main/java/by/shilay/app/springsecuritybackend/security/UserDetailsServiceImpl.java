package by.shilay.app.springsecuritybackend.security;

import by.shilay.app.springsecuritybackend.model.User;
import by.shilay.app.springsecuritybackend.service.api.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getOne(email);
        if (user == null) {
            throw new UsernameNotFoundException("User with email: " + email + " not found!");
        }
        return new UserDetailsImpl(user);
    }
}
