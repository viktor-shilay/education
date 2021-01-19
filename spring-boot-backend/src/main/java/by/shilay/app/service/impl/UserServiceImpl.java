package by.shilay.app.service.impl;

import by.shilay.app.dto.UserDTO;
import by.shilay.app.model.User;
import by.shilay.app.repository.UserRepository;
import by.shilay.app.service.api.RoleService;
import by.shilay.app.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    public List<UserDTO> findAll() {
        //add log
        List<User> users = userRepository.findAll();
        List<UserDTO> userDtos = new ArrayList<>();
        for (User user: users){
            UserDTO userDTO = new UserDTO(user.getId(), user.getFirstName(), user.getLastName(),
                    user.getEmail(),user.getPassword(),user.isBlocked());
            userDtos.add(userDTO);
        }
        return userDtos;
    }

    @Override
    public List<UserDTO> findByFirstNameOrLastNameContaining(String firstName, String lastName) {
        List<User> users = userRepository.findByFirstNameOrLastNameContaining(firstName, lastName);
        List<UserDTO> userDtos = new ArrayList<>();
        for (User user: users){
            UserDTO userDTO = new UserDTO(user.getId(), user.getFirstName(), user.getLastName(),
                    user.getEmail(),user.getPassword(),user.isBlocked());
            userDtos.add(userDTO);
        }
        return userDtos;
    }

    @Override
    public Optional<User> findByUserId(Long id) {
        //add log
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User create(UserDTO userDTO) {
        //add log
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setBlocked(userDTO.isBlocked());
        user.setRole(roleService.getByName("ROLE_STUDENT"));
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
