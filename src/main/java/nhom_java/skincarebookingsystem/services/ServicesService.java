package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.models.Service;
import nhom_java.skincarebookingsystem.repositories.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServicesService {
    @Autowired
    private ServicesRepository servicesRepository;

    public List<Service> findAll() {
        return servicesRepository.findAll();
    }

    public Service createService(Service services) {
        return servicesRepository.save(services);
    }

    public Service updateService(Service services) {
        return servicesRepository.save(services);
    }
}
