package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.Checkin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CheckinRepository extends JpaRepository<Checkin, Long> {
    List<Checkin> findAll();
}
