package nhom_java.skincarebookingsystem.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceResponse {
    private Long serviceId;
    private String name;
    private String description;
    private Double price;
    private Integer duration;
}
