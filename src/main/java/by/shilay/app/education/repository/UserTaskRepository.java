package by.shilay.app.education.repository;

import by.shilay.app.education.model.UserTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTaskRepository extends JpaRepository<UserTasks, Long> {

}
