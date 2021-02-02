package by.shilay.app.service.impl;

import by.shilay.app.model.UserGroup;
import by.shilay.app.repository.UserGroupRepository;
import by.shilay.app.service.api.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGroupServiceImpl implements UserGroupService {

    private final UserGroupRepository userGroupRepository;

    @Autowired
    public UserGroupServiceImpl(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

    @Override
    public UserGroup getByGroup(String group) {
        return userGroupRepository.findByGroup(group);
    }
}
