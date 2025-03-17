package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.models.Payment;
import nhom_java.skincarebookingsystem.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }
    public Payment CreatePayment(Payment payment){
        return paymentRepository.save(payment);
    }
    public Payment updatePayment(Payment payment){
        return paymentRepository.save(payment);
    }
    public void deletePayment(Long id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Payment with ID " + id + " not found");
        }
    }
}
