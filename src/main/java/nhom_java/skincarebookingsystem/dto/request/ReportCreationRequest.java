package nhom_java.skincarebookingsystem.dto.request;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class ReportCreationRequest {
    @Column
    private String email;
    private String reportType;
    private String content;
    private LocalDateTime creationDate;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
