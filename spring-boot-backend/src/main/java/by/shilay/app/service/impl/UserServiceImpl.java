package by.shilay.app.service.impl;

import by.shilay.app.dto.UserDTO;
import by.shilay.app.model.User;
import by.shilay.app.repository.UserRepository;
import by.shilay.app.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        //add log
        List<User> users = userRepository.findAll();
        List<UserDTO> userDtos = new ArrayList<>();
        for (User user: users){
            UserDTO userDTO = new UserDTO(user.getId(), user.getFirstName(), user.getLastName(),
                    user.getEmail(),user.getIsBlocked());
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
                    user.getEmail(),user.getIsBlocked());
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
    public User create(User user) {
        //add log
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
