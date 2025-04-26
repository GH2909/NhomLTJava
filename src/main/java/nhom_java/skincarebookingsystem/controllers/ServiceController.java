package nhom_java.skincarebookingsystem.controllers;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nhom_java.skincarebookingsystem.dto.request.ApiResponse;
import nhom_java.skincarebookingsystem.dto.request.ServiceRequest;
import nhom_java.skincarebookingsystem.dto.response.ServiceResponse;
import nhom_java.skincarebookingsystem.models.ServiceEntity;
import nhom_java.skincarebookingsystem.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ServiceController {
    @Autowired
    ServiceService serviceService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse<ServiceResponse> createService(
            @RequestParam("image") MultipartFile image,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") Double price,
            @RequestParam("duration") Integer duration) throws IOException {
        // Lưu file vào thư mục static/assets/img
        String uploadDir = "src/main/resources/static/assets/img/";
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String fileName = image.getOriginalFilename();
        Path filePath = Paths.get(uploadDir + fileName);
        Files.write(filePath, image.getBytes());
        // Tạo request với tên file ảnh
        ServiceRequest request = new ServiceRequest();
        request.setName(name);
        request.setDescription(description);
        request.setPrice(price);
        request.setDuration(duration);
        request.setImageUrl(fileName);
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
    public ApiResponse<List<ServiceResponse>> getAllServices() {
        // Lấy danh sách các dịch vụ từ service layer
        List<ServiceResponse> services = serviceService.getAllServices();
        System.out.println("Getting all services: " + services.size() + " services found");

        // Trả về danh sách dịch vụ trong ApiResponse
        return ApiResponse.<List<ServiceResponse>>builder()
                .result(services)
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<ServiceResponse> getServiceById(@PathVariable Long id) {
        // Lấy thông tin dịch vụ qua service layer
        ServiceResponse serviceResponse = serviceService.getServiceById(id);

        // Trả về kết quả trong ApiResponse
        return ApiResponse.<ServiceResponse>builder()
                .result(serviceResponse)
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
