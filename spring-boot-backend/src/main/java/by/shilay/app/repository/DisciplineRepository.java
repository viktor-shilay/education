package by.shilay.app.repository;

import by.shilay.app.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    Optional<Discipline> findAllById(Long id);
    Discipline findByName(String name);
    List<Discipline> findAllByName(String name);
    List<Discipline> findAllByUserId(Long id);
}
