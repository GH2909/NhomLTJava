package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "service_result")
public class ServiceResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false, unique = true)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "therapist_id", nullable = false)
    private SkinTherapist therapist;

    @Column(nullable = false, length = 1000)
    private String resultDescription;

    @Column(nullable = false)
    private LocalDate completionDate;

    public ServiceResult() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public SkinTherapist getTherapist() {
        return therapist;
    }

    public void setTherapist(SkinTherapist therapist) {
        this.therapist = therapist;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }
}
