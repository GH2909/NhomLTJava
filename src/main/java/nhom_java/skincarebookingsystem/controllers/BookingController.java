package nhom_java.skincarebookingsystem.controllers;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nhom_java.skincarebookingsystem.dto.request.ApiResponse;
import nhom_java.skincarebookingsystem.dto.request.BookingRequest;
import nhom_java.skincarebookingsystem.dto.response.BookingResponse;
import nhom_java.skincarebookingsystem.models.Booking;
import nhom_java.skincarebookingsystem.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping
    public ApiResponse<BookingResponse> createBooking(@RequestBody @Valid BookingRequest request) {
        return ApiResponse.<BookingResponse>builder()
                .result(bookingService.createBooking(request))
                .build();
    }

    @GetMapping
    public ApiResponse<List<BookingResponse>> getBookings() {
        return ApiResponse.<List<BookingResponse>>builder()
                .result(bookingService.getAllBookings())
                .build();
    }

    @GetMapping("/email")
    public ApiResponse<BookingResponse> getBooking(String email) {
        return ApiResponse.<BookingResponse>builder()
                .result(bookingService.getBooking(email))
                .build();
    }

    @DeleteMapping
    public ApiResponse<String> deleteBooking(@PathVariable String email) {
        bookingService.deleteBooking(email);
        return ApiResponse.<String>builder()
                .result("Booking has been deleted successfully.")
                .build();
    }
}
