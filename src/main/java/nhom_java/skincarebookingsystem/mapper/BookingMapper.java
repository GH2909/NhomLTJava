package nhom_java.skincarebookingsystem.mapper;

import nhom_java.skincarebookingsystem.dto.request.BookingRequest;
import nhom_java.skincarebookingsystem.dto.request.UserUpdateRequest;
import nhom_java.skincarebookingsystem.dto.response.*;
import nhom_java.skincarebookingsystem.models.Booking;
import nhom_java.skincarebookingsystem.models.Role;
import nhom_java.skincarebookingsystem.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
@Component
public class BookingMapper {
    public Booking toBooking(BookingRequest request){
        if (request == null) {
            return null;
        }
        Booking booking = new Booking();
        booking.setFullName(request.getFullName());
        booking.setEmail(request.getEmail());
        booking.setPhone(request.getPhone());
        booking.setAddress(request.getAddress());
        booking.setSelectedService(request.getSelectedService());
        booking.setBookingDate(request.getBookingDate());
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
        bookingResponse.setSelectedService(booking.getSelectedService());
        bookingResponse.setBookingDate(booking.getBookingDate());
        List<ServiceResponse> services = booking.getServices().stream().map((service) -> {
            ServiceResponse resSer = new ServiceResponse();
            resSer.setName(service.getName());
            return resSer;
        }).toList();
        Set<ServiceResponse> targetSet = new HashSet<>(services);
        bookingResponse.setServices(targetSet);
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
