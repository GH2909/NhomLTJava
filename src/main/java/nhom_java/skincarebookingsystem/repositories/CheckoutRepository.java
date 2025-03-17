package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.Checkin;
import nhom_java.skincarebookingsystem.models.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
    List<Checkout> findAll();
}
