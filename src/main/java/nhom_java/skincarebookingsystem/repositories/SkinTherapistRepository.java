package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.SkinTherapist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface SkinTherapistRepository extends JpaRepository<SkinTherapist, Long> {
    Optional<SkinTherapist> findByEmail(String email);
    void deleteByEmail(String email);
    boolean existsByEmail(String email);
}
