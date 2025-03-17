package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
