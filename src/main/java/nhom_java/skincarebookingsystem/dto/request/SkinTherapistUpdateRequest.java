package nhom_java.skincarebookingsystem.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SkinTherapistUpdateRequest {
    String password;
    String skinTherapistName;
    String Specialization;
    Integer ExperienceYears;
    String DescriptionS;
    String Images;
}
