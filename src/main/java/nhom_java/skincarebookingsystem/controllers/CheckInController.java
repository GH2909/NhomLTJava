package nhom_java.skincarebookingsystem.controllers;

import nhom_java.skincarebookingsystem.dto.request.CheckInCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.CheckInUpdateRequest;
import nhom_java.skincarebookingsystem.models.CheckIn;
import nhom_java.skincarebookingsystem.services.CheckInService;
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

    @GetMapping("/booking/{bookingId}")
    public CheckIn getCheckInByBookingId(@PathVariable Long bookingId) {
        return checkInService.getCheckInByBookingEmail(bookingId);
    }

    @PutMapping("/{email}")
    public CheckIn updateCheckIn(@PathVariable Long id, @RequestBody CheckInUpdateRequest request) {
        return checkInService.updateCheckIn(id, request);
    }

    @DeleteMapping("/{email}")
    public String deleteCheckIn(@PathVariable Long id) {
        checkInService.deleteCheckIn(id);
        return "CheckIn deleted successfully";
    }
}
