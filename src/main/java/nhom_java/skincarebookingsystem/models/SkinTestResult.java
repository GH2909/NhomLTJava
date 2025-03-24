package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;

@Entity
public class SkinTestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultID;

    @OneToOne
    @JoinColumn(name = "skinTest_id", nullable = false)
    private SkinTest skinTest;

    @Column(nullable = false)
    private String skinIssues;

    @Column(nullable = false)
    private String recommendedServices;

    public SkinTestResult() {}

    public Long getResultID() {
        return resultID;
    }

    public void setResultID(Long resultID) {
        this.resultID = resultID;
    }

    public SkinTest getSkinTest() {
        return skinTest;
    }

    public void setSkinTest(SkinTest skinTest) {
        this.skinTest = skinTest;
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

