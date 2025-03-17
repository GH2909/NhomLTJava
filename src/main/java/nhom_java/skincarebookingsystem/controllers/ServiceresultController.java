package nhom_java.skincarebookingsystem.controllers;
import nhom_java.skincarebookingsystem.models.Serviceresult;
import nhom_java.skincarebookingsystem.services.ServiceresultService;
import nhom_java.skincarebookingsystem.repositories.ServiceresultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/serviceresult")
public class ServiceresultController {
    @Autowired
    private ServiceresultService serviceresultService;

    @GetMapping("/serviceresults")
    public List<Serviceresult> getAllServiceresults(){
        return serviceresultService.findAll();
    }

    @PostMapping("/serviceresult")
    public Serviceresult addServiceresult(@RequestBody Serviceresult serviceresult){
        return serviceresultService.CreateServiceresult(serviceresult);
    }

    @PutMapping("/serviceresult/{id}")
    public Serviceresult updateServiceresult(@RequestBody Serviceresult serviceresult){
        return serviceresultService.CreateServiceresult(serviceresult);
    }

    @DeleteMapping("/serviceresult/{id}")
    public String deleteServiceresult(@PathVariable Long id) {
        serviceresultService.DeleteServiceresult(id);
        return "Service result với ID " + id + " đã bị xóa.";
    }
}
