package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.Feedback;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findAll();
}

