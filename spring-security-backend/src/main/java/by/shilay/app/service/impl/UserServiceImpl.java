package by.shilay.app.service.impl;

import by.shilay.app.model.User;
import by.shilay.app.config.URLConstants;
import by.shilay.app.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;

    @Autowired
    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getAll(String name){
        List<User> users = new ArrayList<>();
        if (name == null){
            users.addAll(restTemplate.getForObject(URLConstants.USERS_URL, List.class));
        }else {
            users.addAll(restTemplate.getForObject(URLConstants.USERS_URL + "?name=" + name, List.class));
        }
        if (users.isEmpty()){
            return null;
        }
        return users;
    }

    @Override
    public User getById(Long id) {
        return restTemplate.getForObject(URLConstants.USERS_URL + "/" + id, User.class);
    }

    @Override
    public User getByEmail(String email) {
        try {
            return restTemplate.getForObject(URLConstants.USERS_URL + "/email/" + email, User.class);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public User create(User user) {
        return restTemplate.postForObject(URLConstants.USERS_URL, user, User.class);
    }
}
