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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@Service
public class BookingService {

    BookingRepository bookingRepository;
    BookingMapper bookingMapper ;
    UserRepository userRepository;
    ServiceRepository serviceRepository;


    public BookingResponse createBooking(BookingRequest request) {
        Booking booking = bookingMapper.toBooking(request);

        if (request.getServiceId() != null) {
            ServiceEntity service = serviceRepository.findById(request.getServiceId())
                    .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
            booking.setService(service);
        }
// Xử lý Payment Status
        if ("BANK_TRANSFER".equalsIgnoreCase(request.getPaymentMethod())) {
            booking.setPaymentStatus("UNPAID"); // chọn chuyển khoản
        } else if ("CASH".equalsIgnoreCase(request.getPaymentMethod())) {
            booking.setPaymentStatus("PAID_LATER"); // chọn tiền mặt
        } else {
            booking.setPaymentStatus("UNKNOWN"); // phòng khi dữ liệu lỗi
        }

        // Gán trạng thái booking mặc định
        booking.setStatus("Chưa thực hiện");
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
        // Tìm booking theo email
        BookingResponse bookingResponse = bookingRepository.findByEmail(email)
                .map(bookingMapper::toBookingResponse)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_EXISTED));

        // Trả về danh sách chứa một phần tử
        return List.of(bookingResponse);
    }


    public void deleteBooking(String email) {
        if (!bookingRepository.existsByEmail(email)) {
            throw new AppException(ErrorCode.NOT_FOUND);
        }
        bookingRepository.deleteByEmail(email);
    }

    public void updateStatus(Long bookingId, String newStatus) {
        System.out.println("Đang cập nhật trạng thái cho bookingId: " + bookingId + " với trạng thái mới: " + newStatus);

        // Kiểm tra xem có tìm thấy booking hay không
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        if (optionalBooking.isPresent()) {
            System.out.println("Booking tìm thấy với ID: " + bookingId);

            // Lấy đối tượng Booking và cập nhật trạng thái
            Booking booking = optionalBooking.get();
            booking.setStatus(newStatus);

            // Lưu lại booking với trạng thái mới
            bookingRepository.save(booking);
            System.out.println("Cập nhật trạng thái thành công cho bookingId: " + bookingId);
        } else {
            // Nếu không tìm thấy booking
            System.out.println("Không tìm thấy booking với id: " + bookingId);
            throw new RuntimeException("Booking not found with id: " + bookingId);
        }
    }



}
