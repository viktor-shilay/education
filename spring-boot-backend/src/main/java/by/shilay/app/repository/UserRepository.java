package by.shilay.app.repository;

import by.shilay.app.model.Role;
import by.shilay.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findAllByRoleRole(String role);
    List<User> findAllByUserGroupGroup(String group);
    List<User> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
}
