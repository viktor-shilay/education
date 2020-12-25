package by.shilay.app.education.service.impl;

import by.shilay.app.education.model.User;
import by.shilay.app.education.repository.UserRepository;
import by.shilay.app.education.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        //add log
        return userRepository.findAll();
    }

    public Long create(User user) {
        //add log
        return userRepository.save(user).getId();
    }
}
