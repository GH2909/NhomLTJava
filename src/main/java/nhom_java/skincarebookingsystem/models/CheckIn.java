package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "check_in")
public class CheckIn extends Customer{

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false, unique = true)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    @Column(nullable = false)
    private LocalDateTime checkInTime;

    public CheckIn() {}

    public CheckIn(Booking booking, Staff staff, LocalDateTime checkInTime) {
        this.booking = booking;
        this.staff = staff;
        this.checkInTime = checkInTime;
    }


    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }
}
