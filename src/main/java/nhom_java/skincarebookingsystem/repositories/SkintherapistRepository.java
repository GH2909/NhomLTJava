package nhom_java.skincarebookingsystem.repositories;
import jakarta.persistence.Entity;
import nhom_java.skincarebookingsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import nhom_java.skincarebookingsystem.models.Skintherapist;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository

public interface SkintherapistRepository extends JpaRepository<Skintherapist, Long> {
    Optional<Skintherapist> findByTherapistId(Long therapistId);
    List<Skintherapist> findAllByTherapistId();
    Skintherapist createSkintherapist(Skintherapist skintherapist);
    Skintherapist updateSkintherapist(Skintherapist skintherapist);
    ResponseEntity<String> deleteByTherapistId(Long therapistId);
}
