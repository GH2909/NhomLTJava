package nhom_java.skincarebookingsystem.controllers;

import nhom_java.skincarebookingsystem.dto.request.CheckOutCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.CheckOutUpdateRequest;
import nhom_java.skincarebookingsystem.models.CheckOut;
import nhom_java.skincarebookingsystem.services.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkout")
public class CheckOutController {

    @Autowired
    private CheckOutService checkOutService;

    @PostMapping
    public CheckOut createCheckOut(@RequestBody CheckOutCreationRequest request) {
        return checkOutService.createCheckOut(request);
    }

    @GetMapping
    public List<CheckOut> getAllCheckOuts() {
        return checkOutService.getAllCheckOuts();
    }

    @GetMapping("/{email}")
    public CheckOut getCheckOutByBookingId(@PathVariable String email) {
        return checkOutService.getCheckOutByBookingId(email);
    }

    @PutMapping("/{email}")
    public CheckOut updateCheckOut(@PathVariable String email, @RequestBody CheckOutUpdateRequest request) {
        return checkOutService.updateCheckOut(email, request);
    }

    @DeleteMapping("/{email}")
    public String deleteCheckOut(@PathVariable String email) {
        checkOutService.deleteCheckOut(email);
        return "CheckOut deleted successfully";
    }
}
