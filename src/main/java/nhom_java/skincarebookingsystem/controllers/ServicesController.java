package nhom_java.skincarebookingsystem.controllers;

import nhom_java.skincarebookingsystem.models.Services;
import nhom_java.skincarebookingsystem.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicesController {
    @Autowired
    private ServicesService servicesService;

    @GetMapping("/all")
    public List<Services> getAllServices() {
        return servicesService.findAll();
    }

    @PostMapping("/add")
    public Services addService(@RequestBody Services services) {
        return servicesService.createService(services);
    }

    @PutMapping("/update/{id}")
    public Services updateService(@RequestBody Services services) {
        return servicesService.updateService(services);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteService(@PathVariable Long id) {
        return servicesService.deleteServiceById(id);
    }
}
