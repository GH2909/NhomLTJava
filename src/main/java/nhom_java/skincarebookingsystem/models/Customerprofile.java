package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "customerprofile")
public class Customerprofile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProfileID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CustomerID", nullable = false)
    private Customer customerID;

    @Lob
    @Column(name = "BookingHistory")
    private String bookingHistory;

    @Column(name = "SkinType")
    private String skinType;

    @Lob
    @Column(name = "SkinIssues")
    private String skinIssues;

    @Lob
    @Column(name = "Notes")
    private String notes;

    @Column(name = "LastVisit")
    private Instant lastVisit;

}