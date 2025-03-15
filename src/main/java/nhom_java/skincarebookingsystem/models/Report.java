package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReportID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ManagerID", nullable = false)
    private Manager managerID;

    @Column(name = "ReportType")
    private String reportType;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "CreationDate")
    private Instant creationDate;

    @Lob
    @Column(name = "Content")
    private String content;

}