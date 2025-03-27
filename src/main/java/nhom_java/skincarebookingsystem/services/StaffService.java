package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.models.Staff;
import nhom_java.skincarebookingsystem.repositories.StaffRepository;
import nhom_java.skincarebookingsystem.repositories. ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    private final StaffRepository staffRepository;
    private final  ScheduleRepository  ScheduleRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository,  ScheduleRepository  ScheduleRepository) {
        this.staffRepository = staffRepository;
        this. ScheduleRepository =  ScheduleRepository;
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Optional<Staff> getStaffById(Long id) {
        return staffRepository.findById(id);
    }

    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public Staff updateStaff(Long id, Staff updatedStaff) {
        return staffRepository.findById(id).map(existingStaff -> {
            existingStaff.setFullName(updatedStaff.getFullName());
            existingStaff.setEmail(updatedStaff.getEmail());
            existingStaff.setPhone(updatedStaff.getPhone());
            existingStaff.setPassword(updatedStaff.getPassword());
            existingStaff.setPosition(updatedStaff.getPosition());

            if (updatedStaff.getWorkSchedule() != null) {
                existingStaff.setWorkSchedule(updatedStaff.getWorkSchedule());
            }

            return staffRepository.save(existingStaff);
        }).orElseThrow(() -> new RuntimeException("Staff not found with ID: " + id));
    }


    // Xóa nhân viên theo ID
    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }
}
