package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.models.Manager;
import nhom_java.skincarebookingsystem.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
}
