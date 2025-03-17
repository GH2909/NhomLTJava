package nhom_java.skincarebookingsystem.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import nhom_java.skincarebookingsystem.services.SkintherapistService;
import nhom_java.skincarebookingsystem.repositories.SkintherapistRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import java.util.*;
import nhom_java.skincarebookingsystem.models.Skintherapist;
import org.springframework.stereotype.Controller;
@Controller
@RestController
@RequestMapping("/s")

public class SkintherapistController {
    @Autowired
    SkintherapistRepository skintherapistService;
    @GetMapping("/therapists")
    public List<Skintherapist> findAllByTherapistId(){
        return skintherapistService.findAllByTherapistId();
    }
    @PostMapping("/therapist")
    public Skintherapist createSkintherapist(Skintherapist skintherapist){
        return skintherapistService.createSkintherapist(skintherapist);
    }
    @PutMapping("/therapist")
    public Skintherapist updateSkintherapist(Skintherapist skintherapist){
        return skintherapistService.updateSkintherapist(skintherapist);
    }
    @DeleteMapping("/therapist")
    public ResponseEntity<String> deleteByTherapistId(Long therapistId){
        Optional<Skintherapist> the = SkintherapistService.findByTherapistId(therapistId);
        if (the.isPresent()){
            the=Optional.empty();
            return ResponseEntity.ok("Đã được xóa");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User ko ton tai");
    }
}
