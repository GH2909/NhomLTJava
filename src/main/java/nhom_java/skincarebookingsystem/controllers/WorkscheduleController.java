package nhom_java.skincarebookingsystem.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import nhom_java.skincarebookingsystem.services.WorkscheduleService;
import nhom_java.skincarebookingsystem.repositories.WorkscheduleRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import java.util.*;
import nhom_java.skincarebookingsystem.models.Workschedule;
import org.springframework.stereotype.Controller;
@Controller
@RestController
@RequestMapping("/w")

public class WorkscheduleController {
    @Autowired
    private WorkscheduleService workscheduleService;
    @GetMapping("/works")
    public List<Workschedule> findAllByWorkDate(){
        return workscheduleService.findAllByWorkDate();
    }
    @PostMapping("/work")
    public Workschedule createWorkschedule(@RequestBody Workschedule workschedule){
        return workscheduleService.createWorkschedule(workschedule);
    }
    @PutMapping("/work")
    public Workschedule updateWorkschedule(@RequestBody Workschedule workschedule){
        return workscheduleService.updateWorkschedule(workschedule);
    }
    @DeleteMapping("/work")
    public ResponseEntity<String> deleteByWorkDate(@RequestBody Date date){
        Optional<Workschedule> work =workscheduleService.findByWorkDate(date);
        if (work.isPresent()){
            work=Optional.empty();
            return ResponseEntity.ok("Đã được xóa");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User ko ton tai");
    }
}
