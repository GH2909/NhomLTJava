package nhom_java.skincarebookingsystem.dto.response;

import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

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
    String selectedService;
    LocalDate bookingDate;
    Set<ServiceResponse> services;
}
