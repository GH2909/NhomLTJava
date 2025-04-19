package nhom_java.skincarebookingsystem.dto.request;

import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingRequest {
    String fullName;
    @Email(message = "Invalid email format")
    String email;
    String phone;
    String address;
    LocalDate bookingDate;
    Long serviceId;
    Long staffId;
    Long therapistId;
}
