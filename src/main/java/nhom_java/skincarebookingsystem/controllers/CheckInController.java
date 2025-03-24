package nhom_java.skincarebookingsystem.controllers;

import nhom_java.skincarebookingsystem.dto.request.CheckInCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.CheckInUpdateRequest;
import nhom_java.skincarebookingsystem.models.CheckIn;
import nhom_java.skincarebookingsystem.services.CheckInService;
import org.apache.naming.factory.SendMailFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkin")
public class CheckInController {

    @Autowired
    private CheckInService checkInService;

    @PostMapping
    public CheckIn createCheckIn(@RequestBody CheckInCreationRequest request) {
        return checkInService.createCheckIn(request);
    }

    @GetMapping
    public List<CheckIn> getAllCheckIns() {
        return checkInService.getAllCheckIns();
    }

    @GetMapping("/{email}")
    public CheckIn getCheckInByBookingId(@PathVariable String email) {
        return checkInService.getCheckIn(email);
    }

    @PutMapping("/{email}")
    public CheckIn updateCheckIn(@PathVariable String email, @RequestBody CheckInUpdateRequest request) {
        return checkInService.updateCheckIn(email, request);
    }

    @DeleteMapping("/{email}")
    public String deleteCheckIn(@PathVariable String email) {
        checkInService.deleteCheckIn(email);
        return "CheckIn deleted successfully";
    }
}
