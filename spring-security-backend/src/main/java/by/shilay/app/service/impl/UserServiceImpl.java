package by.shilay.app.service.impl;

import by.shilay.app.model.User;
import by.shilay.app.config.URLConstants;
import by.shilay.app.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;

    @Autowired
    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getAll() {
        try {
            return restTemplate.getForObject(URLConstants.USERS_URL, List.class);
        } catch (Exception ex) {
            log.error("Method getAll() error: " + ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public User getOne(String email) {
        try {
            return restTemplate.getForObject(URLConstants.USERS_URL + "/email/" + email, User.class);
        } catch (Exception ex) {
            log.error("User method getOne() error: " + ex);
            throw new RuntimeException(ex);
        }
    }
}
