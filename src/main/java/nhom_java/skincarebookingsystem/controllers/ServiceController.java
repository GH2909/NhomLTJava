package nhom_java.skincarebookingsystem.controllers;

import jakarta.validation.Valid;
import nhom_java.skincarebookingsystem.dto.request.ApiResponse;
import nhom_java.skincarebookingsystem.dto.request.ServiceRequest;
import nhom_java.skincarebookingsystem.dto.response.ServiceResponse;
import nhom_java.skincarebookingsystem.models.ServiceEntity;
import nhom_java.skincarebookingsystem.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping
    public ApiResponse<ServiceResponse> createService(@RequestBody @Valid ServiceRequest request) {
        return ApiResponse.<ServiceResponse>builder()
                .result(serviceService.createService(request))
                .build();
    }


//    @PutMapping("/{id}")
//    public ApiResponse<ServiceEntity> updateService(@PathVariable Long id, @RequestBody @Valid ServiceRequest request) {
//        // Cập nhật dịch vụ thông qua service layer
//        ServiceEntity updatedService = serviceService.updateService(id, request);
//
//        // Trả về kết quả trong ApiResponse
//        return ApiResponse.<ServiceEntity>builder()
//                .result(updatedService)
//                .build();
//    }

    @GetMapping
    public ApiResponse<List<ServiceEntity>> getAllServices() {
        // Lấy danh sách các dịch vụ từ service layer
        List<ServiceEntity> services = serviceService.getAllServices();
        System.out.println("Getting all services: " + services.size() + " services found");

        // Trả về danh sách dịch vụ trong ApiResponse
        return ApiResponse.<List<ServiceEntity>>builder()
                .result(services)
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<ServiceEntity> getServiceById(@PathVariable Long id) {
        // Lấy thông tin dịch vụ qua service layer
        ServiceEntity serviceEntity = serviceService.getServiceById(id);

        // Trả về kết quả trong ApiResponse
        return ApiResponse.<ServiceEntity>builder()
                .result(serviceEntity)
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteService(@PathVariable Long id) {
        // Gọi phương thức để xóa dịch vụ
        serviceService.deleteService(id);

        // Trả về kết quả trong ApiResponse
        return ApiResponse.<String>builder()
                .result("Service has been deleted successfully.")
                .build();
    }
}
