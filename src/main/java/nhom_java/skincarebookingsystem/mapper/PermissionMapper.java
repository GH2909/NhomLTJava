package nhom_java.skincarebookingsystem.mapper;

import nhom_java.skincarebookingsystem.dto.request.PermissionRequest;
import nhom_java.skincarebookingsystem.dto.response.PermissionResponse;
import nhom_java.skincarebookingsystem.models.Permission;
import org.springframework.stereotype.Component;

@Component
public class PermissionMapper {

    public Permission toPermission(PermissionRequest request) {
        if (request == null) {
            return null;
        }
        Permission permission = new Permission();
        permission.setName(request.getName());
        permission.setDescription(request.getDescription());

        return permission;
    }

    public PermissionResponse toPermissionResponse(Permission permission) {
        if (permission == null) {
            return null;
        }
        PermissionResponse response = new PermissionResponse();
        response.setName(permission.getName());
        response.setDescription(permission.getDescription());

        return response;
    }
}
