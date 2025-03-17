package nhom_java.skincarebookingsystem.controllers;

import nhom_java.skincarebookingsystem.models.Booking;
import nhom_java.skincarebookingsystem.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return bookingService.findAll();
    }

    @PostMapping("/booking")
    public Booking addBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @PutMapping("/booking/{id}")
    public Booking updateBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }
}
