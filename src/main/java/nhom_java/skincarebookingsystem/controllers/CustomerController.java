package nhom_java.skincarebookingsystem.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import nhom_java.skincarebookingsystem.services.CustomerService;
import nhom_java.skincarebookingsystem.repositories.CustomerRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import java.util.*;
import nhom_java.skincarebookingsystem.models.Customer;
import nhom_java.skincarebookingsystem.models.User;
import org.springframework.stereotype.Controller;
@Controller
@RestController
@RequestMapping("/cus")

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping ("/customers")
    public List<Customer> findAllByCustomers(){
        return customerService.findAllByCustomers();
    }
    @PostMapping("/customer")
    public Customer createUser(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }
    @PutMapping("/customer")
    public Customer updateUser(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }
    @DeleteMapping("/customer/{customerName}")
    public ResponseEntity<String> deleteCustomer(@RequestBody String customername){
        Optional<Customer> customer =customerService.findByCustomerName(customername);
        if (customer.isPresent()){
            customer=Optional.empty();
            return ResponseEntity.ok("Đã được xóa");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer ko ton tai");
    }
}
