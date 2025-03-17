package nhom_java.skincarebookingsystem.controllers;

import nhom_java.skincarebookingsystem.models.Staff;
import nhom_java.skincarebookingsystem.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @GetMapping("/all")
    public List<Staff> getAllStaffs() {
        return staffService.findAll();
    }

    @PostMapping("/add")
    public Staff addStaff(@RequestBody Staff staff) {
        return staffService.createStaff(staff);
    }

    @PutMapping("/update/{id}")
    public Staff updateStaff(@RequestBody Staff staff) {
        return staffService.updateStaff(staff);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable Long id) {
        return staffService.deleteStaffById(id);
    }
}
