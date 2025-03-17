package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.Cancellation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface CancellationRepository extends JpaRepository<Cancellation,Long> {
    List<Cancellation> findAll();

}
