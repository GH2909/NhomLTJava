package nhom_java.skincarebookingsystem.controllers;

import nhom_java.skincarebookingsystem.dto.request.ApiResponse;
import nhom_java.skincarebookingsystem.dto.request.ManagerUpdateRequest;
import nhom_java.skincarebookingsystem.models.Customer;
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


    @PutMapping("/{email}")
    ApiResponse<Manager> updateManager(@PathVariable String email, @RequestBody ManagerUpdateRequest request) {
        ApiResponse<Manager> apiResponse = new ApiResponse<>();
        apiResponse.setResult(managerService.updateManager(email, request));
        return apiResponse;
    }

    @GetMapping
    ApiResponse<List<Manager>> getAllManagers() {
        return ApiResponse.<List<Manager>>builder()
                .result(managerService.getAllManagers())
                .build();
    }

    @GetMapping("/{email}")
    ApiResponse<Manager> getManager(@PathVariable String email) {
        ApiResponse<Manager> apiResponse = new ApiResponse<>();
        apiResponse.setResult(managerService.getManager(email));
        return apiResponse;
    }

    @DeleteMapping("/{email}")
    ApiResponse<String> deleteManager(@PathVariable String email) {
        ApiResponse<Customer> apiResponse = new ApiResponse<>();
        managerService.deleteManager(email);
        return ApiResponse.<String>builder().result("Manager has been deleted").build();
    }
}
