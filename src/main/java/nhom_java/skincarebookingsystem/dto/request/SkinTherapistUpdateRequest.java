package nhom_java.skincarebookingsystem.dto.request;

public class SkinTherapistUpdateRequest {
    private String password;
    private String skinTherapistName;
    private String Specialization;
    private int ExperienceYears;
    private String DescriptionS;
    private String Images;


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
