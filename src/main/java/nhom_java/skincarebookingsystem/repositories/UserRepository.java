package nhom_java.skincarebookingsystem.repositories;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import nhom_java.skincarebookingsystem.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    List<User> findAllByUser();
    User createUser(User user);
    User updateUser(User user);
    ResponseEntity<String> deleteByUsername(String username);

}
