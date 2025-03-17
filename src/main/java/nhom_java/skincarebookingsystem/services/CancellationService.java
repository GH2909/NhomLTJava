package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.models.Cancellation;
import nhom_java.skincarebookingsystem.repositories.CancellationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CancellationService {
    @Autowired
    private CancellationRepository cancellationRepository;
    public List<Cancellation> findAll() {
        return cancellationRepository.findAll();
    }
    public Cancellation CreateCancellation(Cancellation cancellation){
        return cancellationRepository.save(cancellation);
    }
    public Cancellation updateCancellation(Cancellation cancellation){
        return cancellationRepository.save(cancellation);
    }
    public void deleteCancellation(Long id) {
        if (cancellationRepository.existsById(id)) {
            cancellationRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cancellation with ID " + id + " not found");
        }
    }
}
