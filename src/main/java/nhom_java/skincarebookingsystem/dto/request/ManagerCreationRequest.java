package nhom_java.skincarebookingsystem.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ManagerCreationRequest {
    String email;
    String password;
    boolean monitorFeedback;
    boolean viewReports;
    String manageRole;

    }
