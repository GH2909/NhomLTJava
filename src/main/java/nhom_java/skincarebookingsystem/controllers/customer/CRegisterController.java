package nhom_java.skincarebookingsystem.controllers.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CRegisterController {
    @GetMapping("/customer/register")
    public String logout() {
        return "customer/register";
    }
}
