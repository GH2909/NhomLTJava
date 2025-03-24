package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.SkinTestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkinTestResultRepository extends JpaRepository<SkinTestResult, Long> {
    Optional<SkinTestResult> findBySkinTest_SkinTestID(Long skinTestID);
    void deleteByResultID(Long resultID);
}
