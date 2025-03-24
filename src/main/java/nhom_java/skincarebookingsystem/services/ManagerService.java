package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.dto.request.ManagerCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.ManagerUpdateRequest;
import nhom_java.skincarebookingsystem.models.Manager;
import nhom_java.skincarebookingsystem.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    // Xóa BCryptPasswordEncoder vì không sử dụng mã hóa mật khẩu nữa

    public Manager createManager(ManagerCreationRequest request) {
        // Kiểm tra nếu email đã tồn tại
        if (managerRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email đã tồn tại");
        }

        // Tạo đối tượng Manager mới từ request
        Manager manager = new Manager();
        manager.setEmail(request.getEmail());
        manager.setPassword(request.getPassword()); // Không mã hóa mật khẩu nữa
        manager.setRole(request.getRole());
        manager.setManageServices(request.isManageServices());
        manager.setManageWorkSchedule(request.isManageWorkSchedule());
        manager.setManageTherapists(request.isManageTherapists());
        manager.setManagePayments(request.isManagePayments());
        manager.setMonitorFeedback(request.isMonitorFeedback());
        manager.setViewReports(request.isViewReports());
        manager.setManageCustomers(request.isManageCustomers());

        return managerRepository.save(manager);
    }

    public Manager updateManager(String email, ManagerUpdateRequest request) {
        // Lấy Manager từ email
        Manager manager = getManager(email);

        // Nếu có mật khẩu mới, thay đổi mật khẩu
        if (request.getPassword() != null && !request.getPassword().isEmpty()) {
            manager.setPassword(request.getPassword()); // Không mã hóa mật khẩu
        }

        // Cập nhật các thuộc tính khác
        manager.setManageServices(request.isManageServices());
        manager.setManageWorkSchedule(request.isManageWorkSchedule());
        manager.setManageTherapists(request.isManageTherapists());
        manager.setManagePayments(request.isManagePayments());
        manager.setMonitorFeedback(request.isMonitorFeedback());
        manager.setViewReports(request.isViewReports());
        manager.setManageCustomers(request.isManageCustomers());

        return managerRepository.save(manager);
    }

    public Manager getManager(String email) {
        return managerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Manager not found"));
    }

    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    public void deleteManager(String email) {
        Optional<Manager> manager = managerRepository.findByEmail(email);
        if (manager.isPresent()) {
            managerRepository.deleteByEmail(email);
        } else {
            throw new RuntimeException("Manager not found");
        }
    }
}
