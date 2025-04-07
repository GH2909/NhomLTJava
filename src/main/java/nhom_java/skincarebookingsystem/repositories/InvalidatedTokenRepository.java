package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.InvalidatedToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvalidatedTokenRepository extends JpaRepository<InvalidatedToken, String> {
}
