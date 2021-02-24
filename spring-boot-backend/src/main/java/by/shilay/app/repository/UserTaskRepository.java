package by.shilay.app.repository;

import by.shilay.app.model.UserTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTaskRepository extends JpaRepository<UserTasks, Long> {
    List<UserTasks> findAllByUserId(Long id);
    List<UserTasks> findAllByStudentId(Long id);
    UserTasks findByUserIdAndTaskIdAndStudentId(Long userId, Long TaskId, Long studentId);
}
