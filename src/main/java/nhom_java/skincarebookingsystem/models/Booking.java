package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId; // Khóa chính

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer; // Khách hàng đặt dịch vụ

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service; // Dịch vụ được đặt

    @ManyToOne
    @JoinColumn(name = "therapist_id")
    private SkinTherapist therapist; // Chuyên viên trị liệu (có thể null nếu chưa phân công)

    @Column(nullable = false)
    private LocalDate bookingDate; // Ngày đặt

    @Column(nullable = false)
    private LocalTime time; // Giờ đặt

    @Column(nullable = false)
    private String status; // PENDING, CONFIRMED, CANCELLED, COMPLETED

    public Booking() {}

    // Getters and Setters
    public Long getBookingId() { return bookingId; }
    public void setBookingId(Long bookingId) { this.bookingId = bookingId; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Service getService() { return service; }
    public void setService(Service service) { this.service = service; }

    public SkinTherapist getTherapist() { return therapist; }
    public void setTherapist(SkinTherapist therapist) { this.therapist = therapist; }

    public LocalDate getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDate bookingDate) { this.bookingDate = bookingDate; }

    public LocalTime getTime() { return time; }
    public void setTime(LocalTime time) { this.time = time; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
