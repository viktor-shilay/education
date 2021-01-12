package by.shilay.app.education.service.api;

import by.shilay.app.education.dto.UserDTO;
import by.shilay.app.education.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> findAll();
    List<UserDTO> findByLastNameContaining(String lastName);
    Optional<User> findOne(Long id);
    User create(User user);
    void delete(Long id);
}
