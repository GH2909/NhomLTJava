package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.dto.request.CheckInCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.CheckInUpdateRequest;
import nhom_java.skincarebookingsystem.models.Booking;
import nhom_java.skincarebookingsystem.models.CheckIn;
import nhom_java.skincarebookingsystem.models.Staff;
import nhom_java.skincarebookingsystem.repositories.BookingRepository;
import nhom_java.skincarebookingsystem.repositories.CheckInRepository;
import nhom_java.skincarebookingsystem.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CheckInService {

    @Autowired
    private CheckInRepository checkInRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private StaffRepository staffRepository;

    public CheckIn createCheckIn(CheckInCreationRequest request) {
        Booking booking = bookingRepository.findById(request.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + request.getBookingId()));

        Staff staff = staffRepository.findById(request.getStaffId())
                .orElseThrow(() -> new RuntimeException("Staff not found with ID: " + request.getStaffId()));

        if (checkInRepository.findByBookingId(request.getBookingId()).isPresent()) {
            throw new RuntimeException("CheckIn already exists for Booking ID: " + request.getBookingId());
        }

        CheckIn checkIn = new CheckIn();
        checkIn.setBooking(booking);
        checkIn.setStaff(staff);
        checkIn.setCheckInTime(request.getCheckInTime() != null ? request.getCheckInTime() : LocalDateTime.now());

        return checkInRepository.save(checkIn);
    }

    public List<CheckIn> getAllCheckIns() {
        return checkInRepository.findAll();
    }

    public CheckIn getCheckInByBookingId(String email) {
        return checkInRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("CheckIn not found for Booking ID: " + email));
    }

    public CheckIn updateCheckIn(String email, CheckInUpdateRequest request) {
        CheckIn checkIn = checkInRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("CheckIn not found with ID: " + email));

        checkIn.setCheckInTime(request.getCheckInTime());
        return checkInRepository.save(checkIn);
    }

    @Transactional
    public void deleteCheckIn(Long id) {
        if (!checkInRepository.existsById(id)) {
            throw new RuntimeException("CheckIn with ID " + id + " not found");
        }

        checkInRepository.deleteById(id);
    }
}
