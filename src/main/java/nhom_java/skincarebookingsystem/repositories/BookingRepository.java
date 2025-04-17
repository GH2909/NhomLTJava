package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findByEmail(String email);
    void deleteByEmail(String email);
    boolean existsByEmail(String email);
}
