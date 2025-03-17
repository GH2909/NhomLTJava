package nhom_java.skincarebookingsystem.services;
import nhom_java.skincarebookingsystem.models.User;
import nhom_java.skincarebookingsystem.models.Workschedule;
import nhom_java.skincarebookingsystem.repositories.WorkscheduleRepository;
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class WorkscheduleService {
    @Autowired
    private WorkscheduleRepository workscheduleRepository;
    public Optional<Workschedule> findByWorkDate(Date date){
        return workscheduleRepository.findByWorkDate(date);
    }
    public List<Workschedule> findAllByWorkDate(){
       return workscheduleRepository.findAll();
    }
    public Workschedule createWorkschedule(Workschedule workschedule){
        return workscheduleRepository.save(workschedule);
    }
    public Workschedule updateWorkschedule(Workschedule workschedule){
        return workscheduleRepository.save(workschedule);
    }
    public ResponseEntity<String> deleteByWorkDate(Date date){
        Optional<Workschedule> work =findByWorkDate(date);
        if (work.isPresent()){
            workscheduleRepository.delete(work.get());
            return ResponseEntity.ok("Đã được xóa");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User ko ton tai");
    }

}
