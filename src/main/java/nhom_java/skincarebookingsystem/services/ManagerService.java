package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.models.Manager;
import nhom_java.skincarebookingsystem.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public List<Manager> findAll() {
        return managerRepository.findAll();
    }

    public Manager createManager(Manager manager) {
        return managerRepository.save(manager);
    }

    public Manager updateManager(Manager manager) {
        return managerRepository.save(manager);
    }

    @Transactional
    public ResponseEntity<String> deleteManagerById(Long id) {
        Optional<Manager> manager = managerRepository.findById(id);
        if (manager.isPresent()) {
            managerRepository.delete(manager.get());
            return ResponseEntity.ok("Quản lý đã được xóa!");
        }
        return ResponseEntity.badRequest().body("Không tìm thấy quản lý.");
    }
}
