package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.models.Checkin;
import nhom_java.skincarebookingsystem.repositories.CheckinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckinService {
    @Autowired
    private CheckinRepository checkinRepository;

    public List<Checkin> findAll() {
        return checkinRepository.findAll();
    }

    public Checkin CreateCheckin(Checkin checkin) {
        return checkinRepository.save(checkin);
    }

    public Checkin UpdateCheckin(Checkin checkin) {
        Optional<Checkin> checkinOptional = checkinRepository.findById(checkin.getId());
        if(checkinOptional.isPresent()){
            Checkin checkin1 = checkinOptional.get();
            checkin1.setBookingID(checkin.getBookingID());
            checkin1.setStaffID(checkin.getStaffID());
            checkin1.setCheckInTime(checkin.getCheckInTime());
            return checkinRepository.save(checkin1);
        }
        else {
            throw new RuntimeException("Checkin with ID " + checkin.getId() + " not found.");
        }
    }

    public void deleteCheckin(Long id) {
        if (checkinRepository.existsById(id)) {
            checkinRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Check-in với ID" + id + " không tồn tại.");
        }
    }
}

