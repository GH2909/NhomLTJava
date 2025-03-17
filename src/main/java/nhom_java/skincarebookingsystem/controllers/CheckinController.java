package nhom_java.skincarebookingsystem.controllers;
import nhom_java.skincarebookingsystem.models.Checkin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import nhom_java.skincarebookingsystem.services.CheckinService;

import java.util.List;


@RestController
@RequestMapping("/checkin")
public class CheckinController {
    @Autowired
    private CheckinService checkinService;

    @GetMapping("/checkins")
    public List<Checkin> getAllCheckins(){
        return checkinService.findAll();
    }

    @PostMapping("/checkin")
    public Checkin addCheckin(@RequestBody Checkin checkin){
        return checkinService.CreateCheckin(checkin);
    }

    @PutMapping("/checkin/{id}")
    public Checkin updateCheckin(@RequestBody Checkin checkin){
        return checkinService.CreateCheckin(checkin);
    }

    @DeleteMapping("/checkin/{id}")
    public String deleteCheckin(@PathVariable Long id){
        checkinService.deleteCheckin(id);
        return "Check-in với ID " + id + " đã bị xóa.";
    }
}