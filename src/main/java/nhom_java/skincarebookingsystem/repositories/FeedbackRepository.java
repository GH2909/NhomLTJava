package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long>{
    Optional<Feedback> findByEmail(String email);
    void deleteByEmail(String email);
}
