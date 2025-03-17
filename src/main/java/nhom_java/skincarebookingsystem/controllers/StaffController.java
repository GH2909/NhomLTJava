package nhom_java.skincarebookingsystem.controllers;

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

    @GetMapping("/staffs")
    public List<Staff> getAllStaffs() {
        return staffService.findAll();
    }

    @PostMapping("/staff")
    public Staff addStaff(@RequestBody Staff staff) {
        return staffService.createStaff(staff);
    }

    @PutMapping("/staff/{id}")
    public Staff updateStaff(@RequestBody Staff staff) {
        return staffService.createStaff(staff);
    }
}
