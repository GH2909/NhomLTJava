package nhom_java.skincarebookingsystem.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nhom_java.skincarebookingsystem.models.Cancellation;
import nhom_java.skincarebookingsystem.services.CancellationService;
import java.util.List;


@RestController
@RequestMapping("/cancellation")
public class CancellationController {
    @Autowired
    private CancellationService cancellationService;
    @GetMapping("/cancellations")
    public List<Cancellation> getAllCancellations() {
        return cancellationService.findAll();
    }
    @PostMapping("/cancellation")
    public Cancellation addCancellation(@RequestBody Cancellation cancellation){
        return cancellationService.CreateCancellation(cancellation);
    }
    @PostMapping("/cancellation/{id}")
    public Cancellation updateCancellation(@RequestBody Cancellation cancellation){
        return cancellationService.CreateCancellation(cancellation);
    }
    @DeleteMapping("/cancellation/{id}")
    public ResponseEntity<String> deleteCancellation(@PathVariable Long id) {
        cancellationService.deleteCancellation(id);
        return ResponseEntity.ok("Cancellation deleted successfully!");
    }
}
