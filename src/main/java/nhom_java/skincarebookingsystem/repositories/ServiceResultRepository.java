package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.ServiceResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceResultRepository extends JpaRepository<ServiceResult, Long> {
    Optional<ServiceResult> findByEmail(String email);

    boolean existsByEmail(String email);
}
