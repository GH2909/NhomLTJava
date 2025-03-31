package nhom_java.skincarebookingsystem.mapper;

import nhom_java.skincarebookingsystem.dto.request.RoleRequest;
import nhom_java.skincarebookingsystem.dto.response.RoleResponse;
import nhom_java.skincarebookingsystem.models.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    public Role toRole(RoleRequest request) {
        if (request == null) {
            return null;
        }
        Role role = new Role();
        role.setName(request.getName());
        role.setDescription(request.getDescription());

        return role;
    }

    public RoleResponse toRoleResponse(Role role) {
        if (role == null) {
            return null;
        }
        RoleResponse response = new RoleResponse();
        response.setName(role.getName());
        response.setDescription(role.getDescription());

        return response;
    }
}
