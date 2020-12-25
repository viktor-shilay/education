package by.shilay.app.education.service.impl;

import by.shilay.app.education.model.Role;
import by.shilay.app.education.repository.RoleRepository;
import by.shilay.app.education.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll(){
        //add log
        return roleRepository.findAll();
    }

    public Long create(Role role){
        //add log
        return roleRepository.save(role).getId();
    }
}
