package nhom_java.skincarebookingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import nhom_java.skincarebookingsystem.models.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface ScheduleRepository extends JpaRepository<WorkSchedule, Long> {
    Optional<WorkSchedule> findByEmail(String email);
    void deleteByEmail(String email);
}
