package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    Optional<Staff> findByEmail(String email);
    void deleteByEmail(String email);
    boolean existsByEmail(String email);
}
