package nhom_java.skincarebookingsystem.mapper;

import lombok.extern.slf4j.Slf4j;
import nhom_java.skincarebookingsystem.dto.request.BookingRequest;
import nhom_java.skincarebookingsystem.dto.response.*;
import nhom_java.skincarebookingsystem.exception.AppException;
import nhom_java.skincarebookingsystem.exception.ErrorCode;
import nhom_java.skincarebookingsystem.models.Booking;
import nhom_java.skincarebookingsystem.models.ServiceEntity;
import nhom_java.skincarebookingsystem.models.User;
import nhom_java.skincarebookingsystem.repositories.ServiceRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
@Slf4j
public class BookingMapper {
    @Autowired
    private ServiceRepository serviceRepository;
    public Booking toBooking(BookingRequest request){
        if (request == null) {
            return null;
        }
        log.info("Service ID nhận được: {}", request.getServiceId());
        ServiceEntity service = serviceRepository.findById(request.getServiceId())
                .orElseThrow(() -> new AppException(ErrorCode.NOT_EXISTED));
        Booking booking = new Booking();
        booking.setFullName(request.getFullName());
        booking.setEmail(request.getEmail());
        booking.setPhone(request.getPhone());
        booking.setAddress(request.getAddress());
        booking.setBookingDate(request.getBookingDate());
        booking.setService(service);
        if (request.getStaffId() != null) {
            User staff = new User();
            staff.setId(request.getStaffId());
            booking.setStaff(staff);
        }

        if (request.getTherapistId() != null) {
            User therapist = new User();
            therapist.setId(request.getTherapistId());
            booking.setTherapist(therapist);
        }

        return booking;
    }
    public BookingResponse toBookingResponse(Booking booking) {
        if (booking == null) {
            return null;
        }
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(booking.getBookingId());
        bookingResponse.setFullName(booking.getFullName());
        bookingResponse.setEmail(booking.getEmail());
        bookingResponse.setPhone(booking.getPhone());
        bookingResponse.setAddress(booking.getAddress());
        bookingResponse.setBookingDate(booking.getBookingDate());
        bookingResponse.setService(booking.getService());
        bookingResponse.setPrice(booking.getPrice());
        bookingResponse.setStaff(booking.getStaff());
        bookingResponse.setTherapist(booking.getTherapist());
        bookingResponse.setStatus("Chưa thực hiện");
        return bookingResponse;
    }

//    public void updateBooking(@MappingTarget Booking booking, UserUpdateRequest request) {
//        user.setFullName(request.getFullName());
//        user.setEmail(request.getEmail());
//        user.setPassword(request.getPassword());
//        user.setPhoneNumber(request.getPhoneNumber());
//        user.setAddress(request.getAddress());
//        List<Role> roles = user.getRoles().stream().map((role) -> {
//            Role resRole = new Role();
//            resRole.setName(role.getName());
//            resRole.setDescription(role.getDescription());
//            resRole.setPermissions(role.getPermissions());
//            return resRole;
//        }).toList();
//        Set<Role> targetSet = new HashSet<>(roles);
//        user.setRoles(targetSet);
//    }

}
