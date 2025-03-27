package nhom_java.skincarebookingsystem.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerCreationRequest {
     String email;
     String role;
     String password;
     String fullName;
     String phoneNumber;
     String address;



}
