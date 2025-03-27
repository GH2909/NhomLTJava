package nhom_java.skincarebookingsystem.dto.request;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class ReportUpdateRequest {
    @Column
    private String reportType;
    private String content;
    private LocalDateTime creationDate;

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
