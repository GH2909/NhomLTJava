package nhom_java.skincarebookingsystem.controllers.admin;

import nhom_java.skincarebookingsystem.dto.request.ApiResponse;
import nhom_java.skincarebookingsystem.dto.response.BookingResponse;
import nhom_java.skincarebookingsystem.models.Booking;
import nhom_java.skincarebookingsystem.services.BookingService;
import org.springframework.ui.Model;import nhom_java.skincarebookingsystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class OrderController {
    @Autowired
    private BookingService bookingService;
    @GetMapping("/order")
    public String order(Model model) {
        List<BookingResponse> bookings = bookingService.getAllBookings();
        model.addAttribute("orders", bookings);
        return "admin/order";
    }
}
