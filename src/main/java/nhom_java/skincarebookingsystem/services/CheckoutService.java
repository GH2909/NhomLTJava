package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.models.Checkout;
import nhom_java.skincarebookingsystem.repositories.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutService {
    @Autowired
    private CheckoutRepository checkoutRepository;
    public List<Checkout> findAll() {
        return checkoutRepository.findAll();
    }
    public Checkout CreateCheckout(Checkout checkout) {
        return checkoutRepository.save(checkout);
    }
    public Checkout UpdateCheckout(Checkout checkout) {
        return checkoutRepository.save(checkout);
    }
}
