package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.Skintest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface SkintestRepository extends JpaRepository<Skintest,Long> {
    List<Skintest> findAll();

}
