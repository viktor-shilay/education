package by.shilay.app.education.service.api;

import by.shilay.app.education.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    Long create(User user);
}
