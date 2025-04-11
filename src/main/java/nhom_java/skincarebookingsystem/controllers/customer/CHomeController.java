package nhom_java.skincarebookingsystem.controllers.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CHomeController {
    @GetMapping("/customer/home")
    public String home() {
        return "customer/home";
    }
}
