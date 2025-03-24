//package nhom_java.skincarebookingsystem.controllers;
//
//import nhom_java.skincarebookingsystem.dto.request.ServiceRequest;
//import nhom_java.skincarebookingsystem.models.Service;
//import nhom_java.skincarebookingsystem.services.ServiceService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/services")
//public class ServiceController {
//
//    @Autowired
//    private ServiceService serviceService;
//
//    @PostMapping
//    public Service createService(@RequestBody ServiceRequest request) {
//        return serviceService.createService(request);
//    }
//
//    @PutMapping("/{id}")
//    public Service updateService(@PathVariable Long id, @RequestBody ServiceRequest request) {
//        return serviceService.updateService(id, request);
//    }
//
//    @GetMapping
//    public List<Service> getAllServices() {
//        return serviceService.getAllServices();
//    }
//
//    @GetMapping("/{id}")
//    public Service getServiceById(@PathVariable Long id) {
//        return serviceService.getServiceById(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteService(@PathVariable Long id) {
//        serviceService.deleteService(id);
//        return "Service has been deleted";
//    }
//}
