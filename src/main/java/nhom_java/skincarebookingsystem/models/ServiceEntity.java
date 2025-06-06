package nhom_java.skincarebookingsystem.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long serviceId;
    String name;
    String description;
    Double price;
    Integer duration; // Tính bằng phút
//    @JsonProperty("img")
    String imageUrl;
}
