package nhom_java.skincarebookingsystem.controllers;
import nhom_java.skincarebookingsystem.models.Checkout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import nhom_java.skincarebookingsystem.services.CheckoutService;

import java.util.List;


@RestController
@RequestMapping("/checkout")
public class CheckoutController {
    @Autowired
    private CheckoutService checkoutService;

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
        return checkoutService.CreateCheckout(checkout);
    }
}
