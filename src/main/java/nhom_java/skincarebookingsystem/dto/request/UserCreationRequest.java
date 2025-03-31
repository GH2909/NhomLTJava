package nhom_java.skincarebookingsystem.dto.request;


import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;
import nhom_java.skincarebookingsystem.models.Role;

import java.awt.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    String email;
    String password;
    String fullName;
    String phoneNumber;
    String address;
    List<String> roles;
}
