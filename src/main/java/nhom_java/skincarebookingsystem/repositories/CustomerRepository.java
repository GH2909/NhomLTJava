package nhom_java.skincarebookingsystem.repositories;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import nhom_java.skincarebookingsystem.models.Customer;
import nhom_java.skincarebookingsystem.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    Optional<Customer> findByCustomerName(String customername);
    List<Customer> findAllByCustomers();
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    ResponseEntity<String> deleteCustomerByName(String customername);

}
