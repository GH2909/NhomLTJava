package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Cancellation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cancellationID;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @Column(nullable = false)
    private String cancelReason;

    @Column(nullable = false)
    private LocalDate cancellationDate;

    @Column
    private Double refundAmount;

    public Cancellation() {}

    public Long getCancellationID() {
        return cancellationID;
    }

    public void setCancellationID(Long cancellationID) {
        this.cancellationID = cancellationID;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public LocalDate getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(LocalDate cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }
}

