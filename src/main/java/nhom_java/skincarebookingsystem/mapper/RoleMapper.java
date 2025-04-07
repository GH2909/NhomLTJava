package nhom_java.skincarebookingsystem.mapper;

import nhom_java.skincarebookingsystem.dto.request.RoleRequest;
import nhom_java.skincarebookingsystem.dto.response.PermissionResponse;
import nhom_java.skincarebookingsystem.dto.response.RoleResponse;
import nhom_java.skincarebookingsystem.models.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
@Component
public class RoleMapper {

    @Mapping(target = "permissions")
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
        List<PermissionResponse> pers = role.getPermissions().stream().map((per) -> {
            PermissionResponse resPer = new PermissionResponse();
            resPer.setName(per.getName());
            resPer.setDescription(per.getDescription());
            return resPer;
        }).toList();
        Set<PermissionResponse> targetSet = new HashSet<>(pers);
        response.setPermissions(targetSet);
    return response;
    }
}
