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
    LocalDate bookingDate;
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    ServiceEntity service;

    Double price;
//    @ManyToOne
//    @JoinColumn(name = "staff_id", nullable = true)
//    User staff;
//
//    @ManyToOne
//    @JoinColumn(name = "therapist_id", nullable = true)
//    User therapist;

    String status;
    String paymentStatus; // trạng thái thanh toán: UNPAID / PAID_LATER / PAID
}
