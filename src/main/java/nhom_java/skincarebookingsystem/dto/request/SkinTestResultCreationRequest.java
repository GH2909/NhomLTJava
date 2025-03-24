package nhom_java.skincarebookingsystem.dto.request;

public class SkinTestResultCreationRequest {
    private Long skinTestID;
    private String skinIssues;
    private String recommendedServices;

    public Long getSkinTestID() {
        return skinTestID;
    }

    public void setSkinTestID(Long skinTestID) {
        this.skinTestID = skinTestID;
    }

    public String getSkinIssues() {
        return skinIssues;
    }

    public void setSkinIssues(String skinIssues) {
        this.skinIssues = skinIssues;
    }

    public String getRecommendedServices() {
        return recommendedServices;
    }

    public void setRecommendedServices(String recommendedServices) {
        this.recommendedServices = recommendedServices;
    }
}
