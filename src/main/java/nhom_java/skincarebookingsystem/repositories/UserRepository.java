package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public interface UserRepository extends JpaRepository<User, String>
{
    void deleteByUsername(String username);
    Optional<User> findByUsername(String username);
}

