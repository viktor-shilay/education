package by.shilay.app.service.api;

import by.shilay.app.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role create(Role role);
    Role getByName(String roleName);
}
