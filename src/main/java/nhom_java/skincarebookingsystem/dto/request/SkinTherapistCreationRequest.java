package nhom_java.skincarebookingsystem.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

public class SkinTherapistCreationRequest {
    private String email;
    private String role;
    private String password;
    private String skinTherapistName;
    private String Specialization;
    private Integer ExperienceYears;
    private String DescriptionS;
    private String Images;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSkinTherapistName() {
        return skinTherapistName;
    }

    public void setSkinTherapistName(String skinTherapistName) {
        this.skinTherapistName = skinTherapistName;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public Integer getExperienceYears() {
        return ExperienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        ExperienceYears = experienceYears;
    }

    public String getDescriptionS() {
        return DescriptionS;
    }

    public void setDescriptionS(String descriptionS) {
        DescriptionS = descriptionS;
    }

    public String getImages() {
        return Images;
    }

    public void setImages(String images) {
        Images = images;
    }
}
