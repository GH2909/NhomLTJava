package nhom_java.skincarebookingsystem.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nhom_java.skincarebookingsystem.models.Skintestresult;
import nhom_java.skincarebookingsystem.services.SkintestresultService;
import java.util.List;


@RestController
@RequestMapping("/skintestresult")
public class SkintestresultController {
    @Autowired
    private SkintestresultService skintestresultService;
    @GetMapping("/skintestresults")
    public List<Skintestresult> getAllSkintestresults() {
        return skintestresultService.findAll();
    }
    @PostMapping("/skintestresult")
    public Skintestresult addSkintestresult(@RequestBody Skintestresult skintestresult){
        return skintestresultService.CreateSkintestresult(skintestresult);
    }
    @PostMapping("/skintestresult/{id}")
    public Skintestresult updateSkintestresult(@RequestBody Skintestresult skintestresult){
        return skintestresultService.CreateSkintestresult(skintestresult);
    }
    @DeleteMapping("/skintestresult/{id}")
    public ResponseEntity<String> deleteSkintestresult(@PathVariable Long id) {
        skintestresultService.deleteSkintestresult(id);
        return ResponseEntity.ok("Skintest result deleted successfully!");
    }
}
