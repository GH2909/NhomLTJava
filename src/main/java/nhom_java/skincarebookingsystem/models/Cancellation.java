package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "cancellation")
public class Cancellation {
    @Id
    @Column(name = "CancellationID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BookingID", nullable = false)
    private Booking bookingID;

    @Column(name = "Reason", length = 1000)
    private String reason;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "CancelledAt")
    private Instant cancelledAt;

}