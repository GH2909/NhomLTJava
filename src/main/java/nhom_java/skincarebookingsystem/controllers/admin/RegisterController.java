package nhom_java.skincarebookingsystem.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
    @GetMapping("/admin/register")
    public String logout() {
        return "admin/register";
    }
}
