package nhom_java.skincarebookingsystem.controllers;

import jakarta.transaction.Transactional;
import nhom_java.skincarebookingsystem.dto.request.ApiResponse;
import nhom_java.skincarebookingsystem.dto.request.SkinTherapistUpdateRequest;
import nhom_java.skincarebookingsystem.models.SkinTherapist;
import nhom_java.skincarebookingsystem.services.SkinTherapistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/thera")
public class SkinTherapistController {
    @Autowired
    SkinTherapistService skinTherapistService;

    @PutMapping("/{email}")
    ApiResponse<SkinTherapist> updateSkinTherapist(@PathVariable String email, @RequestBody SkinTherapistUpdateRequest request){
        ApiResponse<SkinTherapist> apiResponse = new ApiResponse<>();
        apiResponse.setResult(skinTherapistService.updateSkinTherapist(email, request));
        return apiResponse;
    }

    @GetMapping
    ApiResponse<List<SkinTherapist>> getSkinTherapists(){
        return ApiResponse.<List<SkinTherapist>>builder()
                .result(skinTherapistService.getAllSkinTherapist())
                .build();
    }

    @GetMapping("/{email}")
    ApiResponse<SkinTherapist> getSkinTherapist(@PathVariable String email) {
        ApiResponse<SkinTherapist> apiResponse = new ApiResponse<>();
        apiResponse.setResult(skinTherapistService.getSkinTherapist(email));
        return apiResponse;
    }

    @Transactional
    @DeleteMapping("/{email}")
    ApiResponse<String>  deleteSkinTherapist(@PathVariable String email){
        ApiResponse<SkinTherapist> apiResponse = new ApiResponse<>();
        skinTherapistService.deleteSkinTherapist(email);
        return ApiResponse.<String>builder().result("Skin therapist has been deleted").build();
    }
}
