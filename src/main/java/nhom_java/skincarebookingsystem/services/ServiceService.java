//package nhom_java.skincarebookingsystem.services;
//
//import nhom_java.skincarebookingsystem.dto.request.ServiceRequest;
//import nhom_java.skincarebookingsystem.models.Service;
//import nhom_java.skincarebookingsystem.repositories.ServiceRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ServiceService {
//
//    @Autowired
//    private ServiceRepository serviceRepository;
//
//    public Service createService(ServiceRequest request) {
//        if (serviceRepository.findByName(request.getName()).isPresent()) {
//            throw new RuntimeException("Service name already exists");
//        }
//
//        Service service = new Service();
//        service.setName(request.getName());
//        service.setDescription(request.getDescription());
//        service.setPrice(request.getPrice());
//        service.setDuration(request.getDuration());
//
//        return serviceRepository.save(service);
//    }
//
//    public Service updateService(Long id, ServiceRequest request) {
//        Service service = serviceRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Service not found"));
//
//        service.setName(request.getName());
//        service.setDescription(request.getDescription());
//        service.setPrice(request.getPrice());
//        service.setDuration(request.getDuration());
//
//        return serviceRepository.save(service);
//    }
//
//    public List<Service> getAllServices() {
//        return serviceRepository.findAll();
//    }
//
//    public Service getServiceById(Long id) {
//        return serviceRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Service not found"));
//    }
//
//    public void deleteService(Long id) {
//        if (!serviceRepository.existsById(id)) {
//            throw new RuntimeException("Service not found");
//        }
//        serviceRepository.deleteById(id);
//    }
//}
