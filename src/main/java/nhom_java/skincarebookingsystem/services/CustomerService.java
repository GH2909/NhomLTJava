package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.dto.request.CustomerUpdateRequest;
import nhom_java.skincarebookingsystem.enums.Role;
import nhom_java.skincarebookingsystem.models.Customer;
import nhom_java.skincarebookingsystem.exception.AppException;
import nhom_java.skincarebookingsystem.exception.ErrorCode;
import nhom_java.skincarebookingsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
@Service
public class CustomerService{
    @Autowired
    private CustomerRepository customerRepository;


     public Customer updateCustomer(String email, CustomerUpdateRequest request) {
         Customer customer= getCustomer(email);
         customer.setPassword(request.getPassword());
         customer.setFullName(request.getFullName());
         customer.setPhoneNumber(request.getPhoneNumber());
         customer.setAddress(request.getAddress());
         return customerRepository.save(customer);
     }

     public List<Customer> getCustomers() {
         return customerRepository.findAll();
     }

     public Customer getCustomer(String email) {
         return customerRepository.findByEmail(email) .orElseThrow(() -> new RuntimeException("Customer not found"));
     }

     public void deleteCustomer(String email) {
         customerRepository.deleteByEmail(email);
     }
}
