package nhom_java.skincarebookingsystem.controllers;

import jakarta.transaction.Transactional;
import nhom_java.skincarebookingsystem.dto.request.CustomerprofileCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.CustomerprofileUpdateRequest;
import nhom_java.skincarebookingsystem.models.Customerprofile;
import nhom_java.skincarebookingsystem.services.CustomerprofileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cuspro")
public class CustomerprofileController {
    @Autowired
    CustomerprofileService customerprofileService;

    @PostMapping
    Customerprofile createCustomerprofile(@RequestBody CustomerprofileCreationRequest request){
        return customerprofileService.createCustomerprofile(request);
    }

    @GetMapping
    List<Customerprofile> getCustomerprofiles() {
        return customerprofileService.getCustomerprofiles();
    }

    @GetMapping("/{email}")
    Customerprofile getCustomerprofiles(@PathVariable String email){
        return customerprofileService.getCustomerprofile(email);
    }

    @PutMapping("/{email}")
    Customerprofile updateCustomerprofile(@PathVariable String email, @RequestBody CustomerprofileUpdateRequest request){
        return customerprofileService.updateCustomerprofile(email, request);
    }

    @Transactional
    @DeleteMapping("/{email}")
    String deleteCustomerprofile(@PathVariable String email){
        customerprofileService.deleteCustomerprofile(email);
        return "Customerprofile has been deleted";
    }
}
