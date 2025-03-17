package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.models.Serviceresult;
import nhom_java.skincarebookingsystem.repositories.ServiceresultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceresultService {
    @Autowired
    private ServiceresultRepository serviceresultRepository;

    public List<Serviceresult> findAll() {
        return serviceresultRepository.findAll();
    }

    public Serviceresult CreateServiceresult(Serviceresult serviceresult) {
        return serviceresultRepository.save(serviceresult);
    }

    public Serviceresult UpdateServiceresult(Serviceresult serviceresult) {
        Optional<Serviceresult> optional = serviceresultRepository.findById(serviceresult.getId());
        if (optional.isPresent()) {
            Serviceresult serviceresult1 = optional.get();
            serviceresult1.setBookingID(serviceresult.getBookingID());
            serviceresult1.setResultDescription(serviceresult.getResultDescription());
            serviceresult1.setCompletionDate(serviceresult.getCompletionDate());
            return serviceresultRepository.save(serviceresult1);
        }
        else {
            throw new RuntimeException("Serviceresult với ID " + serviceresult.getId() + " không tồn tại.");
        }
    }

    public void DeleteServiceresult(Long id) {
        if (serviceresultRepository.existsById(id)) {
            serviceresultRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Serviceresult với ID \" + id + \" không tồn tại.");
        }
    }
}
