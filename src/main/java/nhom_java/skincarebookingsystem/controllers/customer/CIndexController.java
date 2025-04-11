package nhom_java.skincarebookingsystem.controllers.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CIndexController {
   @GetMapping("/customer/index")
   public String index() {
       return "customer/index";
   }
}
