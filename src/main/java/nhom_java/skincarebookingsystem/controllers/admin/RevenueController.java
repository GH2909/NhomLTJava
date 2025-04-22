package nhom_java.skincarebookingsystem.controllers.admin;

import nhom_java.skincarebookingsystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/revenue")
public class RevenueController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/daily")
    public ResponseEntity<?> getDailyRevenue(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        BigDecimal revenue = bookingRepository.calculateRevenueByDate(date);
        return ResponseEntity.ok(Map.of("revenue", revenue));
    }

    @GetMapping("/monthly")
    public ResponseEntity<?> getMonthlyRevenue(@RequestParam("month") int month) {
        LocalDate now = LocalDate.now();
        YearMonth yearMonth = YearMonth.of(now.getYear(), month);
        BigDecimal revenue = bookingRepository.calculateRevenueByMonth(yearMonth.atDay(1), yearMonth.atEndOfMonth());
        return ResponseEntity.ok(Map.of("revenue", revenue));
    }

    @GetMapping("/yearly")
    public ResponseEntity<?> getYearlyRevenue(@RequestParam("year") int year) {
        LocalDate start = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year, 12, 31);
        BigDecimal revenue = bookingRepository.calculateRevenueByYear(start, end);
        return ResponseEntity.ok(Map.of("revenue", revenue));
    }
}
