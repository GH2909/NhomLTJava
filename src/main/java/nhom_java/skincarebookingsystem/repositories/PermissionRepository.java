package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {

}
