package nhom_java.skincarebookingsystem.controllers;

import nhom_java.skincarebookingsystem.models.Service;
import nhom_java.skincarebookingsystem.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicesController {
    @Autowired
    private ServicesService servicesService;

    @GetMapping
    public List<Service> getAllServices() {
        return servicesService.findAll();
    }

    @PostMapping
    public Service addService(@RequestBody Service service) {
        return servicesService.createService(service);
    }

    @PutMapping("/{id}")
    public Service updateService(@RequestBody Service service) {
        return servicesService.updateService(service);
    }
//    @DeleteMapping ty lam
}
