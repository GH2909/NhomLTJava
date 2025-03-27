package nhom_java.skincarebookingsystem.dto.request;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CustomerUpdateRequest {
    private String password;
    private String fullName;
    private String phoneNumber;
    private String address;
}