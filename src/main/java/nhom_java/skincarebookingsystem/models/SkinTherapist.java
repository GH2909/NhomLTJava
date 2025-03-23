package nhom_java.skincarebookingsystem.models;


import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "user_id")
public class SkinTherapist extends User {
    private String skinTherapistName;
    private String Specialization;
    private Integer ExperienceYears;
    private String DescriptionS;
    private String Images;

    public SkinTherapist() {}

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
        this.Specialization = specialization;
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
