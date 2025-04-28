package nhom_java.skincarebookingsystem.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import nhom_java.skincarebookingsystem.dto.request.BookingRequest;
import nhom_java.skincarebookingsystem.dto.response.BookingResponse;
import nhom_java.skincarebookingsystem.exception.AppException;
import nhom_java.skincarebookingsystem.exception.ErrorCode;
import nhom_java.skincarebookingsystem.mapper.BookingMapper;
import nhom_java.skincarebookingsystem.mapper.UserMapper;
import nhom_java.skincarebookingsystem.models.Booking;
import nhom_java.skincarebookingsystem.models.ServiceEntity;
import nhom_java.skincarebookingsystem.models.User;
import nhom_java.skincarebookingsystem.repositories.BookingRepository;
import nhom_java.skincarebookingsystem.repositories.ServiceRepository;
import nhom_java.skincarebookingsystem.repositories.UserRepository;
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
    ServiceRepository serviceRepository;


    public BookingResponse createBooking(BookingRequest request) {
        Booking booking = bookingMapper.toBooking(request);

        if (request.getServiceId() != null) {
            ServiceEntity service = serviceRepository.findById(request.getServiceId())
                    .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
            booking.setService(service);
        }

        // Tìm và gán Staff nếu có
//        if (request.getStaffId() != null) {
//            User staff = userRepository.findById(request.getStaffId())
//                    .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
//            booking.setStaff(staff);
//        }
//
//        // Tìm và gán Therapist nếu có
//        if (request.getTherapistId() != null) {
//            User therapist = userRepository.findById(request.getTherapistId())
//                    .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
//            booking.setTherapist(therapist);
//        }

        return bookingMapper.toBookingResponse(bookingRepository.save(booking));
    }

    public List<BookingResponse> getAllBookings() {
        return bookingRepository.findAll().stream().map(bookingMapper::toBookingResponse).toList();
    }

    public List<BookingResponse> getBooking(String email) {
        List<Booking> bookings = bookingRepository.findByEmail(email);
        if (bookings.isEmpty()) {
            throw new AppException(ErrorCode.NOT_EXISTED);
        }
        return bookings.stream()
                .map(bookingMapper::toBookingResponse)
                .collect(Collectors.toList());
    }

    public void deleteBooking(String email) {
        if (!bookingRepository.existsByEmail(email)) {
            throw new AppException(ErrorCode.NOT_FOUND);
        }
        bookingRepository.deleteByEmail(email);
    }


}
