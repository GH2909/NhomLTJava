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

    @GetMapping("/booking/{bookingId}")
    public ServiceResult getServiceResultByBookingId(@PathVariable Long bookingId) {
        return serviceResultService.getServiceResultByBookingId(bookingId);
    }

    @PutMapping("/{id}")
    public ServiceResult updateServiceResult(@PathVariable Long id, @RequestBody ServiceResultUpdateRequest request) {
        return serviceResultService.updateServiceResult(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteServiceResult(@PathVariable Long id) {
        serviceResultService.deleteServiceResult(id);
        return "ServiceResult deleted successfully";
    }
}
