package by.shilay.app.repository;

import by.shilay.app.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByUserId(Long reviewer);
    List<Review> findAllByMaterialId(Long id);
    List<Review> findAllByTaskId(Long id);
}
