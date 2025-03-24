package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.CheckOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CheckOutRepository extends JpaRepository<CheckOut, Long> {
    Optional<CheckOut> findByBookingId(Long bookingId);
}
