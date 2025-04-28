package nhom_java.skincarebookingsystem.controllers;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nhom_java.skincarebookingsystem.dto.request.ApiResponse;
import nhom_java.skincarebookingsystem.dto.request.BookingRequest;
import nhom_java.skincarebookingsystem.dto.response.BookingResponse;
import nhom_java.skincarebookingsystem.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/booking")
    public ApiResponse<BookingResponse> createBooking(@RequestBody @Valid BookingRequest request) {
        return ApiResponse.<BookingResponse>builder()
                .result(bookingService.createBooking(request))
                .build();
    }

    @GetMapping("/booking")
    public ApiResponse<List<BookingResponse>> getBookings() {
        return ApiResponse.<List<BookingResponse>>builder()
                .result(bookingService.getAllBookings())
                .build();
    }


    @DeleteMapping("/booking")
    public ApiResponse<String> deleteBooking(@PathVariable String email) {
        bookingService.deleteBooking(email);
        return ApiResponse.<String>builder()
                .result("Booking has been deleted successfully.")
                .build();
    }

}
