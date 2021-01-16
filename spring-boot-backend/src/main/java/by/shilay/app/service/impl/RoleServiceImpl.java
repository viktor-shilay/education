package by.shilay.app.service.impl;

import by.shilay.app.model.Role;
import by.shilay.app.repository.RoleRepository;
import by.shilay.app.service.api.RoleService;
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

    public Role create(Role role){
        //add log
        return roleRepository.save(role);
    }
}
