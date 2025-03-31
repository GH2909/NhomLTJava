package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.dto.request.StaffUpdateRequest;
import nhom_java.skincarebookingsystem.exception.AppException;
import nhom_java.skincarebookingsystem.exception.ErrorCode;
import nhom_java.skincarebookingsystem.models.Staff;
import nhom_java.skincarebookingsystem.repositories.StaffRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class StaffService {
    @Autowired
    private  StaffRepository staffRepository;

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Staff getStaff(String email) {
        return staffRepository.findByEmail(email) .orElseThrow(() -> new RuntimeException("Staff not found"));
    }

    public Staff updateStaff(String email, StaffUpdateRequest request) {
        Staff staff = getStaff(email);
        staff.setPassword(request.getPassword());
        staff.setFullName(request.getFullName());
        staff.setPhoneNumber(request.getPhoneNumber());
        staff.setAddress(request.getAddress());
        return staffRepository.save(staff);
    }


    public void deleteStaff(String email) {
        staffRepository.deleteByEmail(email);
    }
}
