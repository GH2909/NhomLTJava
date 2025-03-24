package nhom_java.skincarebookingsystem.dto.request;

import java.time.LocalDate;

public class SkinTestUpdateRequest {
    private LocalDate testDate;
    private String skinType;

    public LocalDate getTestDate() {
        return testDate;
    }

    public void setTestDate(LocalDate testDate) {
        this.testDate = testDate;
    }

    public String getSkinType() {
        return skinType;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }
}
