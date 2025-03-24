package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.dto.request.CheckOutCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.CheckOutUpdateRequest;
import nhom_java.skincarebookingsystem.models.Booking;
import nhom_java.skincarebookingsystem.models.CheckOut;
import nhom_java.skincarebookingsystem.models.Staff;
import nhom_java.skincarebookingsystem.repositories.BookingRepository;
import nhom_java.skincarebookingsystem.repositories.CheckOutRepository;
import nhom_java.skincarebookingsystem.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CheckOutService {

    @Autowired
    private CheckOutRepository checkOutRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private StaffRepository staffRepository;

    public CheckOut createCheckOut(CheckOutCreationRequest request) {
        Booking booking = bookingRepository.findById(request.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + request.getBookingId()));

        Staff staff = staffRepository.findById(request.getStaffId())
                .orElseThrow(() -> new RuntimeException("Staff not found with ID: " + request.getStaffId()));

        if (checkOutRepository.findByBookingId(request.getBookingId()).isPresent()) {
            throw new RuntimeException("CheckOut already exists for Booking ID: " + request.getBookingId());
        }

        CheckOut checkOut = new CheckOut();
        checkOut.setBooking(booking);
        checkOut.setStaff(staff);
        checkOut.setCheckOutTime(request.getCheckOutTime() != null ? request.getCheckOutTime() : LocalDateTime.now());

        return checkOutRepository.save(checkOut);
    }

    public List<CheckOut> getAllCheckOuts() {
        return checkOutRepository.findAll();
    }

    public CheckOut getCheckOutByBookingId(Long bookingId) {
        return checkOutRepository.findByBookingId(bookingId)
                .orElseThrow(() -> new RuntimeException("CheckOut not found for Booking ID: " + bookingId));
    }

    public CheckOut updateCheckOut(Long id, CheckOutUpdateRequest request) {
        CheckOut checkOut = checkOutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CheckOut not found with ID: " + id));

        checkOut.setCheckOutTime(request.getCheckOutTime());
        return checkOutRepository.save(checkOut);
    }

    @Transactional
    public void deleteCheckOut(Long id) {
        if (!checkOutRepository.existsById(id)) {
            throw new RuntimeException("CheckOut with ID " + id + " not found");
        }

        checkOutRepository.deleteById(id);
    }
}
