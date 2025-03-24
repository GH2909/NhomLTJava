package nhom_java.skincarebookingsystem.dto.request;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class CustomerprofileUpdateRequest {
    private String bookingHistory;
    private String skinType;
    private String skinIssues;
    private String notes;
    private LocalDateTime lastVisit;

    public String getBookingHistory() {
        return bookingHistory;
    }

    public void setBookingHistory(String bookingHistory) {
        this.bookingHistory = bookingHistory;
    }

    public String getSkinType() {
        return skinType;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }

    public String getSkinIssues() {
        return skinIssues;
    }

    public void setSkinIssues(String skinIssues) {
        this.skinIssues = skinIssues;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(LocalDateTime lastVisit) {
        this.lastVisit = lastVisit;
    }
}
