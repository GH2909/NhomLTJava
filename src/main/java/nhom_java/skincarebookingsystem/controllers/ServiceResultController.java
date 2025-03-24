package nhom_java.skincarebookingsystem.controllers;

import nhom_java.skincarebookingsystem.dto.request.ServiceResultCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.ServiceResultUpdateRequest;
import nhom_java.skincarebookingsystem.models.ServiceResult;
import nhom_java.skincarebookingsystem.services.ServiceResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-result")
public class ServiceResultController {

    @Autowired
    private ServiceResultService serviceResultService;

    @PostMapping
    public ServiceResult createServiceResult(@RequestBody ServiceResultCreationRequest request) {
        return serviceResultService.createServiceResult(request);
    }

    @GetMapping
    public List<ServiceResult> getAllServiceResults() {
        return serviceResultService.getAllServiceResults();
    }

    @GetMapping("/{email}")
    public ServiceResult getServiceResultByBookingId(@PathVariable String email) {
        return serviceResultService.getServiceResultByBookingId(email);
    }

    @PutMapping("/{email}")
    public ServiceResult updateServiceResult(@PathVariable String email, @RequestBody ServiceResultUpdateRequest request) {
        return serviceResultService.updateServiceResult(email, request);
    }

    @DeleteMapping("/{email}")
    public String deleteServiceResult(@PathVariable String email) {
        serviceResultService.deleteServiceResult(email);
        return "ServiceResult deleted successfully";
    }
}
