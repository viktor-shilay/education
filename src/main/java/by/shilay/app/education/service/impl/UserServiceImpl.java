package by.shilay.app.education.service.impl;

import by.shilay.app.education.dto.UserDto;
import by.shilay.app.education.model.User;
import by.shilay.app.education.repository.UserRepository;
import by.shilay.app.education.service.api.UserService;
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

    public List<UserDto> findAll() {
        //add log
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user: users){
            UserDto userDto = new UserDto(user.getId(), user.getFirstName(), user.getLastName());
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public Optional<User> findById(Long id) {
        //add log
        return userRepository.findById(id);
    }

    @Override
    public User create(User user) {
        //add log
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        return null;
    }

    @Override
    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
