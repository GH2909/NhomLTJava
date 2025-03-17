package nhom_java.skincarebookingsystem.services;
import nhom_java.skincarebookingsystem.models.Skintherapist;
import nhom_java.skincarebookingsystem.models.Workschedule;
import nhom_java.skincarebookingsystem.repositories.SkintherapistRepository;
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class SkintherapistService {
    @Autowired
    static SkintherapistRepository skintherapistRepository;
    public static Optional<Skintherapist> findByTherapistId(Long therapistId){
        return skintherapistRepository.findByTherapistId(therapistId);
    }
    public List<Skintherapist> findAllByTherapistId(){
        return skintherapistRepository.findAll();
    }
    public Skintherapist createSkintherapist(Skintherapist skintherapist){
        return skintherapistRepository.save(skintherapist);
    }
    public Skintherapist updateSkintherapist(Skintherapist skintherapist){
        return skintherapistRepository.save(skintherapist);
    }
    public ResponseEntity<String> deleteByTherapistId(Long therapistId){
        Optional<Skintherapist> the =findByTherapistId(therapistId);
        if (the.isPresent()){
            skintherapistRepository.delete(the.get());
            return ResponseEntity.ok("Đã được xóa");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User ko ton tai");
    }
}
