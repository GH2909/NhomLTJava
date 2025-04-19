package nhom_java.skincarebookingsystem.mapper;

import nhom_java.skincarebookingsystem.dto.request.ServiceRequest;
import nhom_java.skincarebookingsystem.dto.request.ServiceUpdateRequest;
import nhom_java.skincarebookingsystem.dto.request.UserUpdateRequest;
import nhom_java.skincarebookingsystem.dto.response.ServiceResponse;
import nhom_java.skincarebookingsystem.models.Role;
import nhom_java.skincarebookingsystem.models.ServiceEntity;
import nhom_java.skincarebookingsystem.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
@Component
public class ServiceMapper {

    public ServiceEntity toService(ServiceRequest request) {
        if (request == null) {
            return null;
        }
        ServiceEntity service = new ServiceEntity();
        service.setName(request.getName());
        service.setDescription(request.getDescription());
        service.setDuration(request.getDuration());
        service.setPrice(request.getPrice());
        service.setImageUrl(request.getImageUrl());
        return service;
    }

    public ServiceResponse toServiceResponse(ServiceEntity service) {
        if (service == null) {
            return null;
        }
        ServiceResponse response = new ServiceResponse();
        response.setServiceId(service.getServiceId());
        response.setName(service.getName());
        response.setDescription(service.getDescription());
        response.setDuration(service.getDuration());
        response.setPrice(service.getPrice());
        response.setImageUrl(service.getImageUrl());
        return response;
    }

    public void updateService(@MappingTarget ServiceEntity service, ServiceUpdateRequest request) {

        service.setName(request.getName());
        service.setDescription(request.getDescription());
        service.setDuration(request.getDuration());
        service.setPrice(request.getPrice());
        service.setImageUrl(request.getImageUrl());
    }
}
