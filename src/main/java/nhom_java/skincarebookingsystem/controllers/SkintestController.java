package nhom_java.skincarebookingsystem.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nhom_java.skincarebookingsystem.models.Skintest;
import nhom_java.skincarebookingsystem.services.SkintestService;
import java.util.List;


@RestController
@RequestMapping("/skintest")
public class SkintestController {
    @Autowired
    private SkintestService skintestService;
    @GetMapping("/skintests")
    public List<Skintest> getAllSkintests() {
        return skintestService.findAll();
    }
    @PostMapping("/skintest")
    public Skintest addSkintest(@RequestBody Skintest skintest){
        return skintestService.CreateSkintest(skintest);
    }
    @PostMapping("/skintest/{id}")
    public Skintest updateSkintest(@RequestBody Skintest skintest){
        return skintestService.CreateSkintest(skintest);
    }
    @DeleteMapping("/skintest/{id}")
    public ResponseEntity<String> deleteSkintest(@PathVariable Long id) {
        skintestService.deleteSkintest(id);
        return ResponseEntity.ok("Skintest deleted successfully!");
    }
}
