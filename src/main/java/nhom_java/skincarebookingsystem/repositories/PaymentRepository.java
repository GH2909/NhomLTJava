package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByBooking_BookingId(Long bookingId);
    void deleteByBooking_BookingId(Long bookingId);
}

