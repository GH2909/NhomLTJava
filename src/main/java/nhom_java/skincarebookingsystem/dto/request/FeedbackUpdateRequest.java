package nhom_java.skincarebookingsystem.dto.request;

import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FeedbackUpdateRequest {
    @Column

    private String content;
    private BigDecimal rating;
    private LocalDateTime feedbackDate;

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
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
