package nhom_java.skincarebookingsystem.services;
import nhom_java.skincarebookingsystem.models.Customer;
import nhom_java.skincarebookingsystem.models.User;
import nhom_java.skincarebookingsystem.repositories.CustomerRepository;
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public Optional<Customer> findByCustomerName(String customername) {
        return customerRepository.findByCustomerName(customername);
    }
    public List<Customer> findAllByCustomers(){
        return customerRepository.findAll();
    }
    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    ResponseEntity<String> deleteCustomerByName(String customername){
        Optional<Customer> customer = findByCustomerName(customername);
        if(customer.isPresent()){
            customerRepository.delete(customer.get());
            return ResponseEntity.ok().body("Khách hàng này đã được xóa!");
        }
        return ResponseEntity.badRequest().body("không tìm thấy khách hàng.");
    }

}
