package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "checkin")
public class Checkin {
    @Id
    @Column(name = "CheckInID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BookingID", nullable = false)
    private Booking bookingID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "StaffID", nullable = false)
    private Staff staffID;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "CheckInTime")
    private Instant checkInTime;

}