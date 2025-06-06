package nhom_java.skincarebookingsystem.dto.request;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import nhom_java.skincarebookingsystem.models.Role;
import nhom_java.skincarebookingsystem.validator.DobConstraint;

import java.awt.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Email(message = "Invalid email format")
    String email;

    @Size(min = 6, message = "INVALID_PASSWORD")
    String password;
    String fullName;
    String phoneNumber;
    String address;

    Set<String> roles;
    String specialty;
    String experience;
    String description;


//    @DobConstraint(min = 2, message = "INVALID_DOB")
//    LocalDate dob;

}
