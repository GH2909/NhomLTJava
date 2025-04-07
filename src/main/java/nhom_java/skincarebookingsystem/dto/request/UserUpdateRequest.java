package nhom_java.skincarebookingsystem.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;
import nhom_java.skincarebookingsystem.models.Role;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {

    private String email;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String address;
    private LocalDate dob;
    List<String> roles;

}
