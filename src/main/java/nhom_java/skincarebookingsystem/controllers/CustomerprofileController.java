package nhom_java.skincarebookingsystem.controllers;

import jakarta.transaction.Transactional;
import nhom_java.skincarebookingsystem.dto.request.ApiResponse;
import nhom_java.skincarebookingsystem.dto.request.CustomerprofileCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.CustomerprofileUpdateRequest;
import nhom_java.skincarebookingsystem.models.Customerprofile;
import nhom_java.skincarebookingsystem.services.CustomerprofileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cuspro")
public class CustomerprofileController {
    @Autowired
    CustomerprofileService customerprofileService;

    @PostMapping
    ApiResponse<Customerprofile> createCustomerprofile(@RequestBody CustomerprofileCreationRequest request){
        ApiResponse<Customerprofile> apiResponse = new ApiResponse<>();
        apiResponse.setResult(customerprofileService.createCustomerprofile(request));
        return apiResponse;
    }

    @GetMapping
    ApiResponse<List<Customerprofile>> getCustomerprofiles() {
        ApiResponse<List<Customerprofile>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(customerprofileService.getCustomerprofiles());
        return apiResponse;
    }

    @GetMapping("/{email}")
    ApiResponse<Customerprofile> getCustomerprofiles(@PathVariable String email){
        ApiResponse<Customerprofile> apiResponse = new ApiResponse<>();
        apiResponse.setResult(customerprofileService.getCustomerprofile(email));
        return apiResponse;
    }

    @PutMapping("/{email}")
    ApiResponse<Customerprofile> updateCustomerprofile(@PathVariable String email, @RequestBody CustomerprofileUpdateRequest request){
        ApiResponse<Customerprofile> apiResponse = new ApiResponse<>();
        apiResponse.setResult(customerprofileService.updateCustomerprofile(email, request));
        return apiResponse;
    }

    @Transactional
    @DeleteMapping("/{email}")
    ApiResponse<String> deleteCustomerprofile(@PathVariable String email){
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult("Customerprofile has been deleted");
        customerprofileService.deleteCustomerprofile(email);
        return apiResponse;
    }
}
