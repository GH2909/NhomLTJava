package nhom_java.skincarebookingsystem.controllers;

import nhom_java.skincarebookingsystem.models.Manager;
import nhom_java.skincarebookingsystem.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/all")
    public List<Manager> getAllManagers() {
        return managerService.findAll();
    }

    @PostMapping("/add")
    public Manager addManager(@RequestBody Manager manager) {
        return managerService.createManager(manager);
    }

    @PutMapping("/update/{id}")
    public Manager updateManager(@RequestBody Manager manager) {
        return managerService.updateManager(manager);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteManager(@PathVariable Long id) {
        return managerService.deleteManagerById(id);
    }
}
