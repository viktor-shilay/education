package by.shilay.app.education.service.api;

import by.shilay.app.education.dto.UserDto;
import by.shilay.app.education.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> findAll();
    Optional<User> findById(Long id);
    User create(User user);
    User update(Long id, User user);
    void delete(Long id);
}
