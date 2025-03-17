package nhom_java.skincarebookingsystem.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nhom_java.skincarebookingsystem.models.Payment;
import nhom_java.skincarebookingsystem.services.PaymentService;
import java.util.List;


@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payments")
    public List<Payment> getAllPayments() {
        return paymentService.findAll();
    }

    @PostMapping("/payment")
    public Payment addPayment(@RequestBody Payment payment) {
        return paymentService.CreatePayment(payment);
    }

    @PostMapping("/payment/{id}")
    public Payment updatePayment(@RequestBody Payment payment) {
        return paymentService.CreatePayment(payment);

    }

    @DeleteMapping("/payment/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.ok("Payment deleted successfully!");
    }
}
