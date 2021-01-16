package by.shilay.app.service.api;

import by.shilay.app.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getOne(String email);
}
