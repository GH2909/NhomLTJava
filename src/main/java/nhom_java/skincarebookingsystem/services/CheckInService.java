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
                .orElseThrow(() -> new RuntimeException("Booking không tồn tại"));

        Staff staff = staffRepository.findById(request.getStaffId())
                .orElseThrow(() -> new RuntimeException("Staff không tồn tại"));

        CheckIn checkIn = new CheckIn(booking, staff, request.getCheckInTime());
        return checkInRepository.save(checkIn);
    }

    public List<CheckIn> getAllCheckIns() {
        return checkInRepository.findAll();
    }

    public CheckIn getCheckIn(String email) {
        return checkInRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("CheckIn không tìm thấy cho email: " + email));
    }

    public CheckIn updateCheckIn(String email, CheckInUpdateRequest request) {
        CheckIn checkIn = getCheckIn(email);
        checkIn.setCheckInTime(request.getCheckInTime());
        return checkInRepository.save(checkIn);
    }

    public void deleteCheckIn(String email) {
        CheckIn checkIn = getCheckIn(email);
        checkInRepository.delete(checkIn);
    }
}
