package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {
}
