package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.dto.request.BookingRequest;
import nhom_java.skincarebookingsystem.dto.request.BookingUpdateRequest;
import nhom_java.skincarebookingsystem.models.Booking;
import nhom_java.skincarebookingsystem.models.Customer;
import nhom_java.skincarebookingsystem.models.ServiceEntity;
import nhom_java.skincarebookingsystem.models.SkinTherapist;
import nhom_java.skincarebookingsystem.repositories.BookingRepository;
import nhom_java.skincarebookingsystem.repositories.CustomerRepository;
import nhom_java.skincarebookingsystem.repositories.ServiceRepository;
import nhom_java.skincarebookingsystem.repositories.SkinTherapistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final ServiceRepository serviceRepository;
    private final SkinTherapistRepository skinTherapistRepository;

    @Autowired
    public BookingService(
            BookingRepository bookingRepository,
            CustomerRepository customerRepository,
            ServiceRepository serviceRepository,
            SkinTherapistRepository skinTherapistRepository) {
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.serviceRepository = serviceRepository;
        this.skinTherapistRepository = skinTherapistRepository;
    }

    public Booking createBooking(BookingRequest request) {
        Customer customer = customerRepository.findByEmail(request.getCustomerEmail())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        ServiceEntity service = serviceRepository.findById(request.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found"));

        SkinTherapist therapist = null;
        if (request.getTherapistId() != null) {
            therapist = skinTherapistRepository.findById(request.getTherapistId())
                    .orElseThrow(() -> new RuntimeException("Therapist not found"));
        }

        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setService(service);
        booking.setTherapist(therapist);
        booking.setBookingDate(request.getBookingDate());
        booking.setTime(request.getTime());
        booking.setStatus("PENDING");

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public List<Booking> getBookingsByCustomer(String email) {
        return bookingRepository.findByCustomer_Email(email);
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public Booking updateBookingStatus(Long id, BookingUpdateRequest request) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus(request.getStatus());
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new RuntimeException("Booking not found");
        }
        bookingRepository.deleteById(id);
    }
}
