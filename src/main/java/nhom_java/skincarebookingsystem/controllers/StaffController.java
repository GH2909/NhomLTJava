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

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    // Tạo mới nhân viên
    @PostMapping
    public Staff createStaff(@RequestBody StaffCreationRequest request) {
        // Kiểm tra đầu vào nếu cần
        if (request.getFullName() == null || request.getEmail() == null) {
            throw new IllegalArgumentException("Full name and email are required.");
        }

        Staff staff = new Staff();
        staff.setFullName(request.getFullName());
        staff.setEmail(request.getEmail());
        staff.setPhone(request.getPhone());
        staff.setPassword(request.getPassword());
        return staffService.createStaff(staff);
    }

    @PutMapping("/{id}")
    public Staff updateStaff(@PathVariable Long id, @RequestBody StaffUpdateRequest request) {
        // Kiểm tra đầu vào nếu cần
        if (request.getFullName() == null || request.getEmail() == null) {
            throw new IllegalArgumentException("Full name and email are required.");
        }

        Staff updatedStaff = new Staff();
        updatedStaff.setFullName(request.getFullName());
        updatedStaff.setEmail(request.getEmail());
        updatedStaff.setPhone(request.getPhone());
        updatedStaff.setPassword(request.getPassword());
        return staffService.updateStaff(id, updatedStaff);
    }


    // Lấy danh sách tất cả nhân viên
    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    // Lấy thông tin nhân viên theo id
    @GetMapping("/{id}")
    public Staff getStaff(@PathVariable Long id) {
        return staffService.getStaffById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found with ID: " + id));
    }

    // Xóa nhân viên theo id
    @DeleteMapping("/{id}")
    public String deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
        return "Staff has been deleted";
    }
}
