package nhom_java.skincarebookingsystem.dto.request;

public class BookingUpdateRequest {
    private String status; // CONFIRMED, CANCELLED, COMPLETED

    // Getters and Setters
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
