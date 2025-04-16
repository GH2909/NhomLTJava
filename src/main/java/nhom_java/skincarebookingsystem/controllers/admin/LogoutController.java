package nhom_java.skincarebookingsystem.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
    @GetMapping("/")
    public String logout() {
        return "admin/logout";
    }
}
