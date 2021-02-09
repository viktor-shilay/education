package by.shilay.app.service.impl;

import by.shilay.app.dto.UserDto;
import by.shilay.app.model.User;
import by.shilay.app.repository.UserRepository;
import by.shilay.app.service.api.RoleService;
import by.shilay.app.service.api.UserGroupService;
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
    private final UserGroupService userGroupService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService, UserGroupService userGroupService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.userGroupService = userGroupService;
    }

    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return transferToListDto(users);
    }

    @Override
    public List<UserDto> findByFirstNameOrLastNameContaining(String firstName, String lastName) {
        List<User> users = userRepository.findByFirstNameContainingOrLastNameContaining(firstName, lastName);
        return transferToListDto(users);
    }

    @Override
    public List<UserDto> getAllUsers(String name) {
        List<UserDto> users = new ArrayList<>();
        if (name == null){
            users.addAll(findAll());
        }else {
            users.addAll(findByFirstNameOrLastNameContaining(name, name));
        }
        if (users.isEmpty()){
            return null;
        }
        return users;
    }

    @Override
    public User getByUserId(Long id) {
        Optional<User> userData = userRepository.findById(id);
        if(userData.isPresent()){
            return userData.get();
        }else {
            return null;
        }
    }

    @Override
    public User getByEmail(String email) {
        Optional<User> userData = userRepository.findByEmail(email);
        if (userData.isPresent()){
            return userData.get();
        }else {
            return null;
        }
    }

    @Override
    public UserDto create(UserDto userDTO) {
        return transferToUserDto(userRepository.save(transferToUser(userDTO)));
    }

    @Override
    public User update(Long id, UserDto userDto){
        User updUser = getByUserId(id);
        updUser.setFirstName(userDto.getFirstName());
        updUser.setLastName(userDto.getLastName());
        updUser.setEmail(userDto.getEmail());
        updUser.setBlocked(userDto.isBlocked());
        return userRepository.save(updUser);
    }

    @Override
    public void delete(Long id){
        userRepository.deleteById(id);
    }

    private UserDto transferToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setBlocked(user.isBlocked());
        if (user.getUserGroup() != null){
            userDto.setGroup(user.getUserGroup().getGroup());
        }
        return userDto;
    }
    private User transferToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setBlocked(userDto.isBlocked());
        user.setRole(roleService.getByName("ROLE_STUDENT"));
        user.setUserGroup(userGroupService.getByGroup(userDto.getGroup()));
        return user;
    }

    private List<UserDto> transferToListDto(List<User> users){
        List<UserDto> userDtos = new ArrayList<>();
        for(User temp: users){
            userDtos.add(transferToUserDto(temp));
        }
        return userDtos;
    }
}
