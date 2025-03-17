package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ServicesRepository extends JpaRepository<Service, Long> {
    List<Service> findAll();
}
