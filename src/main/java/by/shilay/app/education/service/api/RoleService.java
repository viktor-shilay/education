package by.shilay.app.education.service.api;

import by.shilay.app.education.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role create(Role role);
}
