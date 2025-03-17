package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.models.Booking;
import nhom_java.skincarebookingsystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Transactional
    public ResponseEntity<String> deleteBookingById(Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (booking.isPresent()) {
            bookingRepository.delete(booking.get());
            return ResponseEntity.ok("Lịch hẹn đã được xóa!");
        }
        return ResponseEntity.badRequest().body("Không tìm thấy lịch hẹn.");
    }
}
