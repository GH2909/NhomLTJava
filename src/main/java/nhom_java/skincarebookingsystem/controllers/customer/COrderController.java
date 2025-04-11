package nhom_java.skincarebookingsystem.controllers.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class COrderController {
    @GetMapping("/customer/order")
    public String order() {
        return "customer/order";
    }
}
