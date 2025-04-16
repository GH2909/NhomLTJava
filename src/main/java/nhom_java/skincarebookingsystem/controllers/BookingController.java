package nhom_java.skincarebookingsystem.controllers;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nhom_java.skincarebookingsystem.dto.request.ApiResponse;
import nhom_java.skincarebookingsystem.dto.request.BookingRequest;
import nhom_java.skincarebookingsystem.dto.request.BookingUpdateRequest;
import nhom_java.skincarebookingsystem.models.Booking;
import nhom_java.skincarebookingsystem.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookingController {

    BookingService bookingService;

    @PostMapping
    public ApiResponse<Booking> createBooking(@RequestBody @Valid BookingRequest request) {
        return ApiResponse.<Booking>builder()
                .result(bookingService.createBooking(request))
                .build();
    }

    @GetMapping
    public ApiResponse<List<Booking>> getBookings() {
        return ApiResponse.<List<Booking>>builder()
                .result(bookingService.getAllBookings())
                .build();
    }

    @PutMapping
    public ApiResponse<Booking> updateBooking(
            @PathVariable Long id,
            @RequestBody @Valid BookingUpdateRequest request
    ) {
        return ApiResponse.<Booking>builder()
                .result(bookingService.updateBooking(id, request))
                .build();
    }

    @DeleteMapping
    public ApiResponse<String> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ApiResponse.<String>builder()
                .result("Booking has been deleted successfully.")
                .build();
    }
}
