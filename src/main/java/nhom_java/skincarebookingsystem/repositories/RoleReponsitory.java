package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface RoleReponsitory extends JpaRepository<Role, String> {
    Optional<Role> findByName(String name);
}
