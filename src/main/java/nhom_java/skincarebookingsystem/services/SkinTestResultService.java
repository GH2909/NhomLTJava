package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.dto.request.SkinTestResultCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.SkinTestResultUpdateRequest;
import nhom_java.skincarebookingsystem.models.SkinTest;
import nhom_java.skincarebookingsystem.models.SkinTestResult;
import nhom_java.skincarebookingsystem.repositories.SkinTestRepository;
import nhom_java.skincarebookingsystem.repositories.SkinTestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkinTestResultService {
    @Autowired
    private SkinTestResultRepository skinTestResultRepository;

    @Autowired
    private SkinTestRepository skinTestRepository;

    public SkinTestResult createSkinTestResult(SkinTestResultCreationRequest request) {
        SkinTest skinTest = skinTestRepository.findById(request.getSkinTestID())
                .orElseThrow(() -> new RuntimeException("Skin Test not found"));

        SkinTestResult result = new SkinTestResult();
        result.setSkinTest(skinTest);
        result.setSkinIssues(request.getSkinIssues());
        result.setRecommendedServices(request.getRecommendedServices());

        return skinTestResultRepository.save(result);
    }

    public SkinTestResult updateSkinTestResult(Long resultID, SkinTestResultUpdateRequest request) {
        SkinTestResult result = getSkinTestResult(resultID);
        result.setSkinIssues(request.getSkinIssues());
        result.setRecommendedServices(request.getRecommendedServices());

        return skinTestResultRepository.save(result);
    }

    public List<SkinTestResult> getAllSkinTestResults() {
        return skinTestResultRepository.findAll();
    }

    public SkinTestResult getSkinTestResult(Long resultID) {
        return skinTestResultRepository.findById(resultID)
                .orElseThrow(() -> new RuntimeException("Skin Test Result not found"));
    }

    public void deleteSkinTestResult(Long resultID) {
        skinTestResultRepository.deleteByResultID(resultID);
    }
}
