package nhom_java.skincarebookingsystem.dto.request;

import jakarta.persistence.Column;

import java.time.Instant;
import java.time.LocalDateTime;

public class FeedbackCreationRequest {
    @Column

    private String email;
    private String content;
    private LocalDateTime feedbackDate;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(LocalDateTime feedbackDate) {
        this.feedbackDate = feedbackDate;
    }
}
