package by.shilay.app.service.api;

import by.shilay.app.dto.UserDto;
import by.shilay.app.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> findAll();
    List<UserDto> findByFirstNameOrLastNameContaining(String firstName, String lastName);
    List<UserDto> getAllUsers(String name);
    List<UserDto> getAllByRole(String role);
    List<User> getAllByGroup(String group);
    User getByUserId(Long id);
    User getByEmail(String email);
    UserDto create(UserDto userDTO);
    User update(Long id, UserDto userDto);
    void delete(Long id);
}
