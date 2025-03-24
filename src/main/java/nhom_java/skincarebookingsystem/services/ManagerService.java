//package nhom_java.skincarebookingsystem.services;
//
//import nhom_java.skincarebookingsystem.dto.request.ManagerCreationRequest;
//import nhom_java.skincarebookingsystem.dto.request.ManagerUpdateRequest;
//import nhom_java.skincarebookingsystem.models.Manager;
//import nhom_java.skincarebookingsystem.repositories.ManagerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ManagerService {
//
//    @Autowired
//    private ManagerRepository managerRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    public Manager createManager(ManagerCreationRequest request) {
//        if (managerRepository.findByEmail(request.getEmail()).isPresent()) {
//            throw new RuntimeException("Email đã tồn tại");
//        }
//
//        Manager manager = new Manager();
//        manager.setEmail(request.getEmail());
//        manager.setPassword(passwordEncoder.encode(request.getPassword())); // Mã hóa mật khẩu
//        manager.setRole(request.getRole());
//        manager.setManageServices(request.isManageServices());
//        manager.setManageWorkSchedule(request.isManageWorkSchedule());
//        manager.setManageTherapists(request.isManageTherapists());
//        manager.setManagePayments(request.isManagePayments());
//        manager.setMonitorFeedback(request.isMonitorFeedback());
//        manager.setViewReports(request.isViewReports());
//        manager.setManageCustomers(request.isManageCustomers());
//
//        return managerRepository.save(manager);
//    }
//
//    public Manager updateManager(String email, ManagerUpdateRequest request) {
//        Manager manager = getManager(email);
//        if (request.getPassword() != null && !request.getPassword().isEmpty()) {
//            manager.setPassword(passwordEncoder.encode(request.getPassword())); // Mã hóa mật khẩu khi cập nhật
//        }
//        manager.setManageServices(request.isManageServices());
//        manager.setManageWorkSchedule(request.isManageWorkSchedule());
//        manager.setManageTherapists(request.isManageTherapists());
//        manager.setManagePayments(request.isManagePayments());
//        manager.setMonitorFeedback(request.isMonitorFeedback());
//        manager.setViewReports(request.isViewReports());
//        manager.setManageCustomers(request.isManageCustomers());
//
//        return managerRepository.save(manager);
//    }
//
//    public Manager getManager(String email) {
//        return managerRepository.findByEmail(email)
//                .orElseThrow(() -> new RuntimeException("Manager not found"));
//    }
//
//    public List<Manager> getAllManagers() {
//        return managerRepository.findAll();
//    }
//
//    public void deleteManager(String email) {
//        Optional<Manager> manager = managerRepository.findByEmail(email);
//        if (manager.isPresent()) {
//            managerRepository.deleteByEmail(email);
//        } else {
//            throw new RuntimeException("Manager not found");
//        }
//    }
//}
