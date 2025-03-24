package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.dto.request.CancellationCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.CancellationUpdateRequest;
import nhom_java.skincarebookingsystem.models.Booking;
import nhom_java.skincarebookingsystem.models.Cancellation;
import nhom_java.skincarebookingsystem.repositories.BookingRepository;
import nhom_java.skincarebookingsystem.repositories.CancellationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancellationService {
    @Autowired
    private CancellationRepository cancellationRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public Cancellation createCancellation(CancellationCreationRequest request) {
        Booking booking = bookingRepository.findById(request.getBookingID())
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Cancellation cancellation = new Cancellation();
        cancellation.setBooking(booking);
        cancellation.setCancelReason(request.getCancelReason());
        cancellation.setCancellationDate(request.getCancellationDate());
        cancellation.setRefundAmount(request.getRefundAmount());

        return cancellationRepository.save(cancellation);
    }

    public Cancellation updateCancellation(Long cancellationID, CancellationUpdateRequest request) {
        Cancellation cancellation = getCancellation(cancellationID);
        cancellation.setCancelReason(request.getCancelReason());
        cancellation.setCancellationDate(request.getCancellationDate());
        cancellation.setRefundAmount(request.getRefundAmount());

        return cancellationRepository.save(cancellation);
    }

    public List<Cancellation> getCancellations() {
        return cancellationRepository.findAll();
    }

    public Cancellation getCancellation(Long cancellationID) {
        return cancellationRepository.findByCancellationID(cancellationID)
                .orElseThrow(() -> new RuntimeException("Cancellation not found"));
    }

    public void deleteCancellation(Long cancellationID) {
        cancellationRepository.deleteByCancellationID(cancellationID);
    }
}
