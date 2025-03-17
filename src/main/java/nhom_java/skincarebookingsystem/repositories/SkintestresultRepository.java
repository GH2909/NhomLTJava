package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.Skintestresult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface SkintestresultRepository extends JpaRepository<Skintestresult,Long> {
    List<Skintestresult> findAll();

}
