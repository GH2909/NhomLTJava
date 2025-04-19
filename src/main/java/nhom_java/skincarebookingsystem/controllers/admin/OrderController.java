package nhom_java.skincarebookingsystem.controllers.admin;

import org.springframework.ui.Model;import nhom_java.skincarebookingsystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class OrderController {
    @Autowired
    private BookingRepository bookingRepository;
    @GetMapping("/order")
    public String order(Model model) {
        model.addAttribute("orders", bookingRepository.findAll());
        return "admin/order";
    }
}
