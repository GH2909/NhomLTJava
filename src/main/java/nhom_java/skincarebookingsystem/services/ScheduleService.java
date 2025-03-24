package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.dto.request.ScheduleCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.ScheduleUpdateRequest;
import nhom_java.skincarebookingsystem.models.WorkSchedule;
import nhom_java.skincarebookingsystem.models.User;
import nhom_java.skincarebookingsystem.repositories.ScheduleRepository;
import nhom_java.skincarebookingsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    UserRepository userRepository;
    public WorkSchedule createSchedule(String email, ScheduleCreationRequest request) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            WorkSchedule workSchedule = new WorkSchedule();
            workSchedule.setWorkDate(request.getWorkDate());
            workSchedule.setStartTime(request.getStartTime());
            workSchedule.setEndTime(request.getEndTime());
            return scheduleRepository.save(workSchedule);
        }
        return null;
    }
    public WorkSchedule updateSchedule(String email, ScheduleUpdateRequest request) {
        WorkSchedule workSchedule = getSchedule(email);
        workSchedule.setWorkDate(request.getWorkDate());
        workSchedule.setStartTime(request.getStartTime());
        workSchedule.setEndTime(request.getEndTime());
        return scheduleRepository.save(workSchedule);

    }
    public List<WorkSchedule> getSchedules() {
        return scheduleRepository.findAll();
    }
    public WorkSchedule getSchedule(String email) {
        return scheduleRepository.findByEmail(email) .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
    public void deleteSchedule(String email) {
        scheduleRepository.deleteByEmail(email);
    }
}
