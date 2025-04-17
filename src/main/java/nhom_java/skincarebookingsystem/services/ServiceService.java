package nhom_java.skincarebookingsystem.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import nhom_java.skincarebookingsystem.dto.request.ServiceRequest;
import nhom_java.skincarebookingsystem.dto.response.ServiceResponse;
import nhom_java.skincarebookingsystem.exception.AppException;
import nhom_java.skincarebookingsystem.exception.ErrorCode;
import nhom_java.skincarebookingsystem.mapper.ServiceMapper;
import nhom_java.skincarebookingsystem.models.ServiceEntity;
import nhom_java.skincarebookingsystem.repositories.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Service
@Slf4j
public class ServiceService {

    ServiceRepository serviceRepository;
    ServiceMapper serviceMapper;

    public ServiceResponse createService(ServiceRequest request) {
        if (serviceRepository.findByName(request.getName()).isPresent()) {
            throw new RuntimeException("Service name already exists");
        }
        ServiceEntity service = serviceMapper.toService(request);

        return serviceMapper.toServiceResponse(serviceRepository.save(service));
    }

//    public ServiceResponse updateService(Long id, ServiceRequest request) {
//        ServiceEntity service = serviceRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Service not found"));
//
//        serviceMapper.updateService
//
//        return serviceRepository.save(service);
//    }

    public List<ServiceResponse> getAllServices() {
        return serviceRepository.findAll().stream()
                .map(serviceMapper::toServiceResponse)
                .toList();
    }

    public ServiceResponse getServiceById(Long id) {
        return serviceMapper.toServiceResponse(serviceRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_EXISTED)));
    }

    public void deleteService(Long id) {
        if (!serviceRepository.existsById(id)) {
            throw new RuntimeException("Service not found");
        }
        serviceRepository.deleteById(id);
    }
}
