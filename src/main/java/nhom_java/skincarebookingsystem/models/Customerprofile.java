package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.time.LocalDateTime;

@Entity
@PrimaryKeyJoinColumn(name = "customer_id")
public class Customerprofile extends Customer{

    @Column(nullable = false)
    private String bookingHistory;
    private String skinType;
    private String skinIssues;
    private String notes;
    private LocalDateTime lastVisit;
    public Customerprofile() {
        this.lastVisit = LocalDateTime.now();
    }

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
