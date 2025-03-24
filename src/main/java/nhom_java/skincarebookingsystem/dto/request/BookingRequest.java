package nhom_java.skincarebookingsystem.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingRequest {
    private String customerEmail;
    private Long serviceId;
    private Long therapistId; // Có thể null nếu chưa chỉ định chuyên viên
    private LocalDate bookingDate;
    private LocalTime time;

    // Getters and Setters
    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    public Long getServiceId() { return serviceId; }
    public void setServiceId(Long serviceId) { this.serviceId = serviceId; }

    public Long getTherapistId() { return therapistId; }
    public void setTherapistId(Long therapistId) { this.therapistId = therapistId; }

    public LocalDate getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDate bookingDate) { this.bookingDate = bookingDate; }

    public LocalTime getTime() { return time; }
    public void setTime(LocalTime time) { this.time = time; }
}
