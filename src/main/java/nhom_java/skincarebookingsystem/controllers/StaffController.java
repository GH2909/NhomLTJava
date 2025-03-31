package nhom_java.skincarebookingsystem.controllers;

import nhom_java.skincarebookingsystem.dto.request.ApiResponse;
import nhom_java.skincarebookingsystem.dto.request.StaffUpdateRequest;
import nhom_java.skincarebookingsystem.models.SkinTherapist;
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


    @PutMapping("/{email}")
    ApiResponse<Staff> updateStaff(@PathVariable String email, @RequestBody StaffUpdateRequest request) {
        ApiResponse<Staff> apiResponse = new ApiResponse<>();
        apiResponse.setResult(staffService.updateStaff(email, request));
        return apiResponse;
    }


    @GetMapping
    public ApiResponse<List<Staff>> getAllStaff() {
        return ApiResponse.<List<Staff>>builder()
                .result(staffService.getAllStaff())
                .build();
    }

    @GetMapping("/{email}")
    ApiResponse<Staff> getStaff(@PathVariable String email) {
        ApiResponse<Staff> apiResponse = new ApiResponse<>();
        apiResponse.setResult(staffService.getStaff(email));
        return apiResponse;
    }


    @DeleteMapping("/{email}")
    ApiResponse<String> deleteStaff(@PathVariable String email) {
        ApiResponse<Staff> apiResponse = new ApiResponse<>();
        staffService.deleteStaff(email);
        return ApiResponse.<String>builder().result("Staff has been deleted").build();
    }
}
