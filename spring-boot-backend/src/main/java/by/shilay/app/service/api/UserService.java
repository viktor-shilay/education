package by.shilay.app.service.api;

import by.shilay.app.dto.UserDTO;
import by.shilay.app.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> findAll();
    List<UserDTO> findByFirstNameOrLastNameContaining(String firstName, String lastName);
    Optional<User> findByUserId(Long id);
    Optional<User> findByEmail(String email);
    User create(UserDTO userDTO);
    void delete(Long id);
}
