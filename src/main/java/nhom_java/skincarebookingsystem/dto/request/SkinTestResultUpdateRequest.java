package nhom_java.skincarebookingsystem.dto.request;

public class SkinTestResultUpdateRequest {
    private String skinIssues;
    private String recommendedServices;

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
