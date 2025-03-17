package nhom_java.skincarebookingsystem.repositories;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import nhom_java.skincarebookingsystem.models.Workschedule;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface WorkscheduleRepository extends JpaRepository<Workschedule,Long> {
    Optional<Workschedule> findByWorkDate(Date date);

    List<Workschedule> findAllByWorkDate();
    Workschedule createWorkschedule(Workschedule workschedule);
    Workschedule updateWorkschedule(Workschedule workschedule);
    ResponseEntity<String> deleteByWorkDate(Date date);

}