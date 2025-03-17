package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.Serviceresult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ServiceresultRepository extends JpaRepository<Serviceresult, Long> {
    List<Serviceresult> findAll();
}