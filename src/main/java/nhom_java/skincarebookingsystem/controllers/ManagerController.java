//package nhom_java.skincarebookingsystem.controllers;
//
//import nhom_java.skincarebookingsystem.dto.request.ManagerCreationRequest;
//import nhom_java.skincarebookingsystem.dto.request.ManagerUpdateRequest;
//import nhom_java.skincarebookingsystem.models.Manager;
//import nhom_java.skincarebookingsystem.services.ManagerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/manager")
//public class ManagerController {
//
//    @Autowired
//    private ManagerService managerService;
//
//    @PostMapping
//    public Manager createManager(@RequestBody ManagerCreationRequest request) {
//        return managerService.createManager(request);
//    }
//
//    @PutMapping("/{email}")
//    public Manager updateManager(@PathVariable String email, @RequestBody ManagerUpdateRequest request) {
//        return managerService.updateManager(email, request);
//    }
//
//    @GetMapping
//    public List<Manager> getAllManagers() {
//        return managerService.getAllManagers();
//    }
//
//    @GetMapping("/{email}")
//    public Manager getManager(@PathVariable String email) {
//        return managerService.getManager(email);
//    }
//
//    @DeleteMapping("/{email}")
//    public String deleteManager(@PathVariable String email) {
//        managerService.deleteManager(email);
//        return "Manager has been deleted";
//    }
//}
