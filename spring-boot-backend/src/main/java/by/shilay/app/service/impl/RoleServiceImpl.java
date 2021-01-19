package by.shilay.app.service.impl;

import by.shilay.app.model.Role;
import by.shilay.app.repository.RoleRepository;
import by.shilay.app.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll(){
        //add log
        return roleRepository.findAll();
    }

    @Override
    public Role create(Role role){
        //add log
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(String roleName) {
        return roleRepository.findByRole(roleName)
                .orElseThrow(
                        () -> new RuntimeException("Role not found!")
                );
    }
}
