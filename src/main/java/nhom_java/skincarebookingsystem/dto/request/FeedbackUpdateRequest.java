package nhom_java.skincarebookingsystem.dto.request;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class FeedbackUpdateRequest {
    @Column

    private String content;
    private LocalDateTime feedbackDate;

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
