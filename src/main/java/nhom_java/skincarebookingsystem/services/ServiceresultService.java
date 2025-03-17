package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.models.Serviceresult;
import nhom_java.skincarebookingsystem.repositories.ServiceresultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return serviceresultRepository.save(serviceresult);
    }
}
