package nhom_java.skincarebookingsystem.controllers;

import nhom_java.skincarebookingsystem.dto.request.StaffCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.StaffUpdateRequest;
import nhom_java.skincarebookingsystem.models.Staff;
import nhom_java.skincarebookingsystem.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping
    public Staff createStaff(@RequestBody StaffCreationRequest request) {
        return staffService.createStaff(request);
    }

    @PutMapping("/{email}")
    public Staff updateStaff(@PathVariable String email, @RequestBody StaffUpdateRequest request) {
        return staffService.updateStaff(email, request);
    }

    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    @GetMapping("/{email}")
    public Staff getStaff(@PathVariable String email) {
        return staffService.getStaff(email);
    }

    @DeleteMapping("/{email}")
    public String deleteStaff(@PathVariable String email) {
        staffService.deleteStaff(email);
        return "Staff has been deleted";
    }
}
