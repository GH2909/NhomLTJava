package nhom_java.skincarebookingsystem.controllers;

import nhom_java.skincarebookingsystem.dto.request.SkinTestCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.SkinTestUpdateRequest;
import nhom_java.skincarebookingsystem.models.SkinTest;
import nhom_java.skincarebookingsystem.services.SkinTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skintests")
public class SkinTestController {
    @Autowired
    private SkinTestService skinTestService;

    @PostMapping
    public SkinTest createSkinTest(@RequestBody SkinTestCreationRequest request) {
        return skinTestService.createSkinTest(request);
    }

    @GetMapping
    public List<SkinTest> getSkinTests() {
        return skinTestService.getSkinTests();
    }

    @GetMapping("/{skinTestID}")
    public SkinTest getSkinTest(@PathVariable Long skinTestID) {
        return skinTestService.getSkinTest(skinTestID);
    }

    @PutMapping("/{skinTestID}")
    public SkinTest updateSkinTest(@PathVariable Long skinTestID, @RequestBody SkinTestUpdateRequest request) {
        return skinTestService.updateSkinTest(skinTestID, request);
    }

    @DeleteMapping("/{skinTestID}")
    public String deleteSkinTest(@PathVariable Long skinTestID) {
        skinTestService.deleteSkinTest(skinTestID);
        return "Skin Test has been deleted";
    }
}
