package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.CheckIn;
import nhom_java.skincarebookingsystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
    Optional<CheckIn> findByEmail(String email);
}
