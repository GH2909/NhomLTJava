package nhom_java.skincarebookingsystem.controllers;

import nhom_java.skincarebookingsystem.models.Manager;
import nhom_java.skincarebookingsystem.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/managers")
    public List<Manager> getAllManagers() {
        return managerService.findAll();
    }

    @PostMapping("/manager")
    public Manager addManager(@RequestBody Manager manager) {
        return managerService.createManager(manager);
    }

    @PutMapping("/manager/{id}")
    public Manager updateManager(@RequestBody Manager manager) {
        return managerService.createManager(manager);
    }
}
