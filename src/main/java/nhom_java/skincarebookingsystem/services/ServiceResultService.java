package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.dto.request.ServiceResultCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.ServiceResultUpdateRequest;
import nhom_java.skincarebookingsystem.models.Booking;
import nhom_java.skincarebookingsystem.models.ServiceResult;
import nhom_java.skincarebookingsystem.models.SkinTherapist;
import nhom_java.skincarebookingsystem.repositories.BookingRepository;
import nhom_java.skincarebookingsystem.repositories.ServiceResultRepository;
import nhom_java.skincarebookingsystem.repositories.SkinTherapistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceResultService {

    @Autowired
    private ServiceResultRepository serviceResultRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SkinTherapistRepository therapistRepository;

    public ServiceResult createServiceResult(ServiceResultCreationRequest request) {
        Booking booking = bookingRepository.findById(request.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + request.getBookingId()));

        SkinTherapist therapist = therapistRepository.findById(request.getTherapistId())
                .orElseThrow(() -> new RuntimeException("Therapist not found with ID: " + request.getTherapistId()));

        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setBooking(booking);
        serviceResult.setTherapist(therapist);
        serviceResult.setResultDescription(request.getResultDescription());
        serviceResult.setCompletionDate(request.getCompletionDate());

        return serviceResultRepository.save(serviceResult);
    }

    public List<ServiceResult> getAllServiceResults() {
        return serviceResultRepository.findAll();
    }

    public ServiceResult getServiceResultByBookingId(Long bookingId) {
        return serviceResultRepository.findByBookingId(bookingId)
                .orElseThrow(() -> new RuntimeException("ServiceResult not found for Booking ID: " + bookingId));
    }

    public ServiceResult updateServiceResult(Long id, ServiceResultUpdateRequest request) {
        ServiceResult serviceResult = serviceResultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ServiceResult not found with ID: " + id));

        serviceResult.setResultDescription(request.getResultDescription());
        serviceResult.setCompletionDate(request.getCompletionDate());
        return serviceResultRepository.save(serviceResult);
    }

    @Transactional
    public void deleteServiceResult(Long id) {
        if (!serviceResultRepository.existsById(id)) {
            throw new RuntimeException("ServiceResult with ID " + id + " not found");
        }

        serviceResultRepository.deleteById(id);
    }
}
