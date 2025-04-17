package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long bookingId;
     String fullName;
     String email;
     String phone;
     String address;
     String selectedService;
     LocalDate bookingDate;
    @ManyToMany
    Set<ServiceEntity> services;

}
