package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.models.Services;
import nhom_java.skincarebookingsystem.repositories.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesService {
    @Autowired
    private ServicesRepository servicesRepository;

    public List<Services> findAll() {
        return servicesRepository.findAll();
    }

    public Services createService(Services services) {
        return servicesRepository.save(services);
    }

    public Services updateService(Services services) {
        return servicesRepository.save(services);
    }

    public ResponseEntity<String> deleteServiceById(Long id) {
        Optional<Services> services = servicesRepository.findById(id);
        if (services.isPresent()) {
            servicesRepository.delete(services.get());
            return ResponseEntity.ok().body("Dịch vụ đã được xóa thành công!");
        }
        return ResponseEntity.badRequest().body("Không tìm thấy dịch vụ.");
    }
}
