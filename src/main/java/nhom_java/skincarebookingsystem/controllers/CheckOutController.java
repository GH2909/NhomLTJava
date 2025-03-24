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

    @GetMapping("/booking/{bookingId}")
    public CheckOut getCheckOutByBookingId(@PathVariable Long bookingId) {
        return checkOutService.getCheckOutByBookingId(bookingId);
    }

    @PutMapping("/{id}")
    public CheckOut updateCheckOut(@PathVariable Long id, @RequestBody CheckOutUpdateRequest request) {
        return checkOutService.updateCheckOut(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteCheckOut(@PathVariable Long id) {
        checkOutService.deleteCheckOut(id);
        return "CheckOut deleted successfully";
    }
}
