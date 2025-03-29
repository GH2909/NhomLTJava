package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.dto.request.ManagerCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.ManagerUpdateRequest;
import nhom_java.skincarebookingsystem.exception.AppException;
import nhom_java.skincarebookingsystem.exception.ErrorCode;
import nhom_java.skincarebookingsystem.models.Manager;
import nhom_java.skincarebookingsystem.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public Manager createManager(ManagerCreationRequest request) {
        Manager manager = new Manager();
        if (managerRepository.existsByEmail((request.getEmail())))
            throw new AppException(ErrorCode.USER_EXISTED);

        manager.setEmail(request.getEmail());
        manager.setPassword(request.getPassword());
        manager.setRole(request.getRole());
        manager.setMonitorFeedback(request.isMonitorFeedback());
        manager.setViewReports(request.isViewReports());
        manager.setManageRole(request.getManageRole());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        manager.setPassword(passwordEncoder.encode(request.getPassword()));
        return managerRepository.save(manager);
    }

    public Manager updateManager(String email, ManagerUpdateRequest request) {
        Manager manager = getManager(email);

        manager.setPassword(request.getPassword());
        manager.setRole(request.getRole());
        manager.setMonitorFeedback(request.isMonitorFeedback());
        manager.setViewReports(request.isViewReports());
        manager.setManageRole(request.getManageRole());

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
