package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public interface UserRepository extends JpaRepository<User, String>
{
    void deleteByEmail(String email);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

    List<User> email(String email);
}

