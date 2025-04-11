package nhom_java.skincarebookingsystem.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
    @GetMapping("/admin/account")
    public String account() {
        return"admin/account";
    }
}
