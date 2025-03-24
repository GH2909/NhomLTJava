package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.SkinTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkinTestRepository extends JpaRepository<SkinTest, Long> {
    Optional<SkinTest> findBySkinTestID(Long skinTestID);
    void deleteBySkinTestID(Long skinTestID);
}
