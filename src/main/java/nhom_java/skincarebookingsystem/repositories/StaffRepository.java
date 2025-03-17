package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    List<Staff> findAll();
}
