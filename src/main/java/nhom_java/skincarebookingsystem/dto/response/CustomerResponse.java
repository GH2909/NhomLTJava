package nhom_java.skincarebookingsystem.dto.response;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponse {
    Long id;
    String email;
    String role;
    String password;
    String fullName;
    String phoneNumber;
    String address;
}
