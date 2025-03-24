package nhom_java.skincarebookingsystem.dto.request;

import jakarta.persistence.Column;

import java.time.Instant;

public class FeedbackUpdateRequest {
    @Column

    private String email;
    private String content;
    private Instant feedbackDate;

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

    public Instant getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Instant feedbackDate) {
        this.feedbackDate = feedbackDate;
    }
}
