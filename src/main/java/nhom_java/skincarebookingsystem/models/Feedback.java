<<<<<<< HEAD
//package nhom_java.skincarebookingsystem.models;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import jakarta.persistence.*;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//@Entity
//@PrimaryKeyJoinColumn(name = "customer_id")
//public class Feedback extends Customer{
//
//    @Column(nullable = false)
//    private String content;
//    @Column(nullable = false, updatable = false)
//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
//    private LocalDateTime feedbackDate;
//    public Feedback() {
//        this.feedbackDate = LocalDateTime.now();
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public LocalDateTime getFeedbackDate() {
//        return feedbackDate;
//    }
//
//    public void setFeedbackDate(LocalDateTime feedbackDate) {
//        this.feedbackDate = feedbackDate;
//    }
//}
=======
package nhom_java.skincarebookingsystem.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@PrimaryKeyJoinColumn(name = "customer_id")
public class Feedback extends Customer{

    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private BigDecimal rating;
    @Column(nullable = false, updatable = false)
//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime feedbackDate;
    public Feedback() {
        this.feedbackDate = LocalDateTime.now();
    }

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
>>>>>>> 19b7972c9144d513f357e9dbd0f7d06b7776f810
