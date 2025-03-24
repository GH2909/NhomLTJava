package nhom_java.skincarebookingsystem.models;
import jakarta.persistence.*;
import java.time.Instant;
@Entity
@PrimaryKeyJoinColumn(name = "customer_id")
public class Feedback extends Customer{

    @Column(nullable = false)
    private String content;
    @Column(nullable = false, updatable = false)
    private Instant feedbackDate = Instant.now();

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
