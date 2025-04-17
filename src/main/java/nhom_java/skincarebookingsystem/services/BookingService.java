package nhom_java.skincarebookingsystem.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import nhom_java.skincarebookingsystem.dto.request.BookingRequest;
import nhom_java.skincarebookingsystem.dto.response.BookingResponse;
import nhom_java.skincarebookingsystem.mapper.BookingMapper;
import nhom_java.skincarebookingsystem.mapper.UserMapper;
import nhom_java.skincarebookingsystem.models.Booking;
import nhom_java.skincarebookingsystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@Service
public class BookingService {

    BookingRepository bookingRepository;
    BookingMapper bookingMapper ;


    public BookingResponse createBooking(BookingRequest request) {
        Booking booking = bookingMapper.toBooking(request);

        return bookingMapper.toBookingResponse(bookingRepository.save(booking));
    }

    public List<BookingResponse> getAllBookings() {
        return bookingRepository.findAll().stream().map(bookingMapper::toBookingResponse).toList();
    }

    public BookingResponse getBooking(String email) {
        return bookingMapper.toBookingResponse(bookingRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Booking not found")));
    }

    public void deleteBooking(String email) {
        if (!bookingRepository.existsByEmail(email)) {
            throw new RuntimeException("Booking not found");
        }
        bookingRepository.deleteByEmail(email);
    }
}
