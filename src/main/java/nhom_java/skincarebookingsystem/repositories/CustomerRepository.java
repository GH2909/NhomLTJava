package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
    void deleteByEmail(String email);
    boolean existsByEmail(String email);
}
