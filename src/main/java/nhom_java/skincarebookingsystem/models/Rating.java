package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RatingID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CustomerID", nullable = false)
    private Customer customerID;

    @Column(name = "RatingScore", precision = 3, scale = 1)
    private BigDecimal ratingScore;

    @Column(name = "Comment", length = 1000)
    private String comment;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "RatingDate")
    private Instant ratingDate;

}