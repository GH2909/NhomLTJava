package nhom_java.skincarebookingsystem.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {
    @GetMapping("/admin/list")
    public String list() {
        return "admin/list";
    }
}
