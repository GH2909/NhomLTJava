package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.models.Checkin;
import nhom_java.skincarebookingsystem.repositories.CheckinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return checkinRepository.save(checkin);
    }
}

