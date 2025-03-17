package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.Customerprofile;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CustomerprofileRepository extends JpaRepository<Customerprofile, Long> {
    List<Customerprofile> findAll();
}

