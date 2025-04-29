package nhom_java.skincarebookingsystem.repositories;

import nhom_java.skincarebookingsystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findByEmail(String email);

    void deleteByEmail(String email);
    boolean existsByEmail(String email);

        // Tính doanh thu theo ngày (Daily)
        @Query("SELECT COALESCE(SUM(b.service.price), 0) FROM Booking b WHERE b.bookingDate = :date")
        BigDecimal calculateRevenueByDate(@Param("date") LocalDate date);

        // Tính doanh thu theo tháng (Monthly)
        @Query("SELECT COALESCE(SUM(b.service.price), 0) FROM Booking b WHERE b.bookingDate BETWEEN :start AND :end")
        BigDecimal calculateRevenueByMonth(@Param("start") LocalDate start, @Param("end") LocalDate end);

        // Tính doanh thu theo năm (Yearly)
        @Query("SELECT COALESCE(SUM(b.service.price), 0) FROM Booking b WHERE b.bookingDate BETWEEN :start AND :end")
        BigDecimal calculateRevenueByYear(@Param("start") LocalDate start, @Param("end") LocalDate end);


}
