package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
    Optional<Object> findByEmail(String email);
}
