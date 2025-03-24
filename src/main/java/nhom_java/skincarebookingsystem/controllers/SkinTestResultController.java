package nhom_java.skincarebookingsystem.controllers;

import nhom_java.skincarebookingsystem.dto.request.SkinTestResultCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.SkinTestResultUpdateRequest;
import nhom_java.skincarebookingsystem.models.SkinTestResult;
import nhom_java.skincarebookingsystem.services.SkinTestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skintestresults")
public class SkinTestResultController {
    @Autowired
    private SkinTestResultService skinTestResultService;

    @PostMapping
    public SkinTestResult createSkinTestResult(@RequestBody SkinTestResultCreationRequest request) {
        return skinTestResultService.createSkinTestResult(request);
    }

    @GetMapping
    public List<SkinTestResult> getAllSkinTestResults() {
        return skinTestResultService.getAllSkinTestResults();
    }

    @GetMapping("/{resultID}")
    public SkinTestResult getSkinTestResult(@PathVariable Long resultID) {
        return skinTestResultService.getSkinTestResult(resultID);
    }

    @PutMapping("/{resultID}")
    public SkinTestResult updateSkinTestResult(@PathVariable Long resultID, @RequestBody SkinTestResultUpdateRequest request) {
        return skinTestResultService.updateSkinTestResult(resultID, request);
    }

    @DeleteMapping("/{resultID}")
    public String deleteSkinTestResult(@PathVariable Long resultID) {
        skinTestResultService.deleteSkinTestResult(resultID);
        return "Skin Test Result has been deleted";
    }
}
