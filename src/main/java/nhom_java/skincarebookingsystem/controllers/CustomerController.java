package nhom_java.skincarebookingsystem.controllers;

import jakarta.transaction.Transactional;
import nhom_java.skincarebookingsystem.dto.request.CustomerCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.CustomerUpdateRequest;
import nhom_java.skincarebookingsystem.models.Customer;
import nhom_java.skincarebookingsystem.services.CustomerService;
import nhom_java.skincarebookingsystem.dto.request.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cus")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    ApiResponse<Customer> createCustomer(@RequestBody CustomerCreationRequest request){
        ApiResponse<Customer> apiResponse = new ApiResponse<>();
        apiResponse.setResult(customerService.createCustomer(request));
        return apiResponse;
    }

    @GetMapping
    ApiResponse <List<Customer>> getCustomers() {
        ApiResponse<List<Customer>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(customerService.getCustomers());
        return apiResponse;
    }

    @GetMapping("/{email}")
    Customer getCustomer(@PathVariable String email){
        return customerService.getCustomer(email);
    }

    @PutMapping("/{email}")
    Customer updateCustomer(@PathVariable String email, @RequestBody CustomerUpdateRequest request){
        return customerService.updateCustomer(email, request);
    }

    @Transactional
    @DeleteMapping("/{email}")
    String deleteCustomer(@PathVariable String email){
        customerService.deleteCustomer(email);
        return "Customer has been deleted";
    }
}

