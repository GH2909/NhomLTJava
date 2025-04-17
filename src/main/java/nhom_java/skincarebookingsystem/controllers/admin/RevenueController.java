package nhom_java.skincarebookingsystem.controllers.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/revenue")
public class RevenueController {

    @GetMapping("/monthly")
    public ResponseEntity<?> getMonthlyRevenue(@RequestParam int month) {
        // logic tính toán doanh thu
        Map<String, Object> result = new HashMap<>();
        result.put("revenue", 12000000);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/daily")
    public ResponseEntity<?> getDailyRevenue(@RequestParam String date) {
        Map<String, Object> result = new HashMap<>();
        result.put("revenue", 700000);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/yearly")
    public ResponseEntity<?> getYearlyRevenue(@RequestParam int year) {
        Map<String, Object> result = new HashMap<>();
        result.put("revenue", 350000000);
        return ResponseEntity.ok(result);
    }
}
