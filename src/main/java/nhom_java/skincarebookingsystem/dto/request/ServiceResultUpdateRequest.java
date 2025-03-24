package nhom_java.skincarebookingsystem.dto.request;

import java.time.LocalDate;

public class ServiceResultUpdateRequest {
    private String resultDescription;
    private LocalDate completionDate;

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }
}
