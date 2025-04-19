package nhom_java.skincarebookingsystem.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceRequest {
    Long serviceId;
    String name;
    String description;
    Double price;
    Integer duration;
    String imageUrl;

}
