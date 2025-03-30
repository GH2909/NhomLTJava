package nhom_java.skincarebookingsystem.controllers;

import jakarta.transaction.Transactional;
import nhom_java.skincarebookingsystem.dto.request.CustomerUpdateRequest;
import nhom_java.skincarebookingsystem.models.Customer;
import nhom_java.skincarebookingsystem.services.CustomerService;
import nhom_java.skincarebookingsystem.dto.request.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cus")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @GetMapping
    ApiResponse<List<Customer>> getCustomers() {
        return ApiResponse.<List<Customer>>builder()
                .result(customerService.getCustomers())
                .build();
    }

    @GetMapping("/{email}")
    ApiResponse<Customer> getCustomer(@PathVariable String email){
        ApiResponse<Customer> apiResponse = new ApiResponse<>();
        apiResponse.setResult(customerService.getCustomer(email));
        return apiResponse;
    }

    @PutMapping("/{email}")
    ApiResponse<Customer> updateCustomer(@PathVariable String email, @RequestBody CustomerUpdateRequest request){
        ApiResponse<Customer> apiResponse = new ApiResponse<>();
        apiResponse.setResult(customerService.updateCustomer(email, request));
        return apiResponse;
    }

    @Transactional
    @DeleteMapping("/{email}")
    ApiResponse<String> deleteCustomer(@PathVariable String email){
        ApiResponse<Customer> apiResponse = new ApiResponse<>();
        customerService.deleteCustomer(email);
        return ApiResponse.<String>builder().result("Customer has been deleted").build();
    }
}

