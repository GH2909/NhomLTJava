//package nhom_java.skincarebookingsystem.services;
//
//import nhom_java.skincarebookingsystem.dto.request.StaffCreationRequest;
//import nhom_java.skincarebookingsystem.dto.request.StaffUpdateRequest;
//import nhom_java.skincarebookingsystem.models.Staff;
//import nhom_java.skincarebookingsystem.models.WorkSchedule;
//import nhom_java.skincarebookingsystem.repositories.StaffRepository;
//import nhom_java.skincarebookingsystem.repositories.WorkScheduleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class StaffService {
//
//    @Autowired
//    private StaffRepository staffRepository;
//
//    @Autowired
//    private WorkScheduleRepository workScheduleRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    public Staff createStaff(StaffCreationRequest request) {
//        if (staffRepository.findByEmail(request.getEmail()).isPresent()) {
//            throw new RuntimeException("Email đã tồn tại");
//        }
//
//        Staff staff = new Staff();
//        staff.setEmail(request.getEmail());
//        staff.setPassword(passwordEncoder.encode(request.getPassword())); // Mã hóa mật khẩu
//        staff.setRole(request.getRole());
//        staff.setFullName(request.getFullName());
//        staff.setPhone(request.getPhone());
//        staff.setPosition(request.getPosition());
//
//        // Kiểm tra và liên kết WorkSchedule nếu có
//        if (request.getWorkScheduleId() != null) {
//            WorkSchedule workSchedule = workScheduleRepository.findById(request.getWorkScheduleId())
//                    .orElseThrow(() -> new RuntimeException("WorkSchedule not found"));
//            staff.setWorkSchedule(workSchedule);
//        }
//
//        return staffRepository.save(staff);
//    }
//
//    public Staff updateStaff(String email, StaffUpdateRequest request) {
//        Staff staff = getStaff(email);
//        if (request.getPassword() != null && !request.getPassword().isEmpty()) {
//            staff.setPassword(passwordEncoder.encode(request.getPassword()));
//        }
//        staff.setFullName(request.getFullName());
//        staff.setPhone(request.getPhone());
//        staff.setPosition(request.getPosition());
//
//        // Cập nhật WorkSchedule nếu có
//        if (request.getWorkScheduleId() != null) {
//            WorkSchedule workSchedule = workScheduleRepository.findById(request.getWorkScheduleId())
//                    .orElseThrow(() -> new RuntimeException("WorkSchedule not found"));
//            staff.setWorkSchedule(workSchedule);
//        }
//
//        return staffRepository.save(staff);
//    }
//
//    public Staff getStaff(String email) {
//        return staffRepository.findByEmail(email)
//                .orElseThrow(() -> new RuntimeException("Staff not found"));
//    }
//
//    public List<Staff> getAllStaff() {
//        return staffRepository.findAll();
//    }
//
//    public void deleteStaff(String email) {
//        Optional<Staff> staff = staffRepository.findByEmail(email);
//        if (staff.isPresent()) {
//            staffRepository.deleteByEmail(email);
//        } else {
//            throw new RuntimeException("Staff not found");
//        }
//    }
//}
