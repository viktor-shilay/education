package by.shilay.app.springsecuritybackend.service.api;

import by.shilay.app.springsecuritybackend.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getOne(String email);
}
