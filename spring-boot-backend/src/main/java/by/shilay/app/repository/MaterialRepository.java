package by.shilay.app.repository;

import by.shilay.app.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
    Optional<Material> findAllById(Long id);
    List<Material> findAllByUserId(Long author);
    List<Material> findAllByDisciplineId(Long id);
}
