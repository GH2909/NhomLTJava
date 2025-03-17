package nhom_java.skincarebookingsystem.controllers;
import nhom_java.skincarebookingsystem.models.Checkout;
import nhom_java.skincarebookingsystem.repositories.CheckoutRepository;
import nhom_java.skincarebookingsystem.services.CheckoutService;
import nhom_java.skincarebookingsystem.repositories.CheckinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/checkout")
public class CheckoutController {
    @Autowired
    private CheckoutService checkoutService;
    @Autowired
    private CheckoutRepository checkoutRepository;

    @GetMapping("/checkouts")
    public List<Checkout> getAllCheckouts(){
        return checkoutService.findAll();
    }

    @PostMapping("/checkout")
    public Checkout addCheckout(@RequestBody Checkout checkout){
        return checkoutService.CreateCheckout(checkout);
    }

    @PutMapping("/checkout/{id}")
    public Checkout updateCheckout(@RequestBody Checkout checkout){
        if (checkout.getId()==null){
            throw new IllegalArgumentException("ID không được null khi cập nhật");
        }
        return checkoutService.UpdateCheckout(checkout);
    }

    @DeleteMapping("/checkout/{id}")
    public void deleteCheckout(@PathVariable Long id){
        checkoutRepository.deleteById(id);
    }
}
