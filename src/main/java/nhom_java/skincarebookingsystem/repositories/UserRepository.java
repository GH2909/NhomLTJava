package nhom_java.skincarebookingsystem.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import nhom_java.skincarebookingsystem.models.User;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findByUserPassword(String userPassword);
    Optional<User> findByEmail(String email);
    Optional<User> findByPhoneNumber(String phoneNumber);
    Optional<User> findByUserRole(String userRole);
}
