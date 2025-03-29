package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.dto.request.StaffCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.StaffUpdateRequest;
import nhom_java.skincarebookingsystem.exception.AppException;
import nhom_java.skincarebookingsystem.exception.ErrorCode;
import nhom_java.skincarebookingsystem.models.Staff;
import nhom_java.skincarebookingsystem.repositories.StaffRepository;
import nhom_java.skincarebookingsystem.repositories. ScheduleRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class StaffService {
    @Autowired
    private  StaffRepository staffRepository;

    public Staff createStaff(StaffCreationRequest request) {
        Staff staff = new Staff();
        if (staffRepository.existsByEmail((request.getEmail())))
            throw new AppException(ErrorCode.USER_EXISTED);
        staff.setEmail(request.getEmail());
        staff.setPassword(request.getPassword());
        staff.setRole(request.getRole());
        staff.setFullName(request.getFullName());
        staff.setPhone(request.getPhone());
        staff.setPossition(request.getPosition());

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        staff.setPassword(passwordEncoder.encode(request.getPassword()));
        return staffRepository.save(staff);
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Staff getStaff(String email) {
        return staffRepository.findByEmail(email) .orElseThrow(() -> new RuntimeException("Staff not found"));
    }

    public Staff updateStaff(String email, StaffUpdateRequest request) {
        Staff staff = getStaff(email);
        staff.setPassword(request.getPassword());
        staff.setRole(request.getRole());
        staff.setFullName(request.getFullName());
        staff.setPhone(request.getPhone());
        staff.setPossition(request.getPosition());
        return staffRepository.save(staff);
    }


    public void deleteStaff(String email) {
        staffRepository.deleteByEmail(email);
    }
}
