package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookingID", nullable = false)
    private Integer id;

    @Column(name = "BookingDate", nullable = false)
    private Instant bookingDate;

    @Column(name = "Time", nullable = false)
    private LocalTime time;

    @Column(name = "Status", length = 20)
    private String status;

}