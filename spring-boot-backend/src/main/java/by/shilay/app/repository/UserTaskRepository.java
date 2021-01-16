package by.shilay.app.repository;

import by.shilay.app.model.UserTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTaskRepository extends JpaRepository<UserTasks, Long> {

}
