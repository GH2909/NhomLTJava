package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.time.LocalDateTime;

@Entity
@PrimaryKeyJoinColumn(name = "manager_id")
public class Report extends Manager{

    @Column(nullable = false)
    private String reportType;
    @Column(nullable = false)
    private String content2;
    @Column(nullable = false, updatable = false)
    private LocalDateTime creationDate;
    public Report(){
        this.creationDate = LocalDateTime.now();
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
