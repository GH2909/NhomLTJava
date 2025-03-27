package nhom_java.skincarebookingsystem.controllers;

import jakarta.transaction.Transactional;
import nhom_java.skincarebookingsystem.dto.request.ApiResponse;
import nhom_java.skincarebookingsystem.dto.request.SkinTherapistCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.SkinTherapistUpdateRequest;
import nhom_java.skincarebookingsystem.models.Customer;
import nhom_java.skincarebookingsystem.models.SkinTherapist;
import nhom_java.skincarebookingsystem.dto.request.ApiResponse;
import nhom_java.skincarebookingsystem.services.SkinTherapistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/thera")
public class SkinTherapistController {
    @Autowired
    SkinTherapistService skinTherapistService;

    @PostMapping
    ApiResponse<SkinTherapist> createSkinTherapist(@RequestBody SkinTherapistCreationRequest request){
        ApiResponse<SkinTherapist> apiResponse = new ApiResponse<>();
        apiResponse.setResult(skinTherapistService.createSkinTherapist(request));
        return apiResponse;
    }

    @PutMapping("/{email}")
    SkinTherapist updateSkinTherapist(@PathVariable String email, @RequestBody SkinTherapistUpdateRequest request){
        return skinTherapistService.updateSkinTherapist(email, request);
    }

    @GetMapping
    List<SkinTherapist> getSkinTherapists(){
        return skinTherapistService.getAllSkinTherapist();
    }

    @GetMapping("/{email}")
    SkinTherapist getSkinTherapist(@PathVariable String email){
        return skinTherapistService.getSkinTherapist(email);
    }

    @Transactional
    @DeleteMapping("/{email}")
    String  deleteSkinTherapist(@PathVariable String email){
        skinTherapistService.deleteSkinTherapist(email);
        return "Therapist has been deleted";
    }
}
