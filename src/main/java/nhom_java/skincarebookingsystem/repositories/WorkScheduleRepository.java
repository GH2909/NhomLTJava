package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Long> {

    // Tìm lịch làm việc theo tên chuyên viên
    Optional<WorkSchedule> findBySkinTherapistName(String skinTherapistName);

    // Tìm lịch làm việc theo ID của chuyên viên da liễu
    Optional<WorkSchedule> findBySkinTherapistId(Long skinTherapistId);
}
