package nhom_java.skincarebookingsystem.dto.response;

import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;
import nhom_java.skincarebookingsystem.models.ServiceEntity;
import nhom_java.skincarebookingsystem.models.User;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingResponse {
    Long bookingId;
    String fullName;
    @Email(message = "Invalid email format")
    String email;
    String phone;
    String address;
    LocalDate bookingDate;
    ServiceEntity service;
    Double price;
    //    User staff;
//    User therapist;
    String status;
    String paymentStatus; // <-- thêm dòng này
}
