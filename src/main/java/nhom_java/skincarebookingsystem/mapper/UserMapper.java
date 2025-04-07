package nhom_java.skincarebookingsystem.mapper;

import nhom_java.skincarebookingsystem.dto.request.UserCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.UserUpdateRequest;
import nhom_java.skincarebookingsystem.dto.response.PermissionResponse;
import nhom_java.skincarebookingsystem.dto.response.RoleResponse;
import nhom_java.skincarebookingsystem.dto.response.UserResponse;
import nhom_java.skincarebookingsystem.models.Role;
import nhom_java.skincarebookingsystem.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
@Component
public class UserMapper {
    public User toUser(UserCreationRequest request){
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFullName(request.getFullName());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setAddress(request.getAddress());
        return user;
    }
    public UserResponse toUserResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setFullName(user.getFullName());
        response.setEmail(user.getEmail());
        response.setPassword(user.getPassword());
        response.setAddress(user.getAddress());
        response.setPhoneNumber(user.getPhoneNumber());
        List<RoleResponse> roles = user.getRoles().stream().map((role) -> {
            RoleResponse resRole = new RoleResponse();
            resRole.setName(role.getName());
            resRole.setDescription(role.getDescription());
            List<PermissionResponse> pers = role.getPermissions().stream().map((per) -> {
                PermissionResponse resPer = new PermissionResponse();
                resPer.setName(per.getName());
                resPer.setDescription(per.getDescription());
                return resPer;
            }).toList();
            Set<PermissionResponse> targetSetPer = new HashSet<>(pers);
            resRole.setPermissions(targetSetPer);
            return resRole;
        }).toList();
        Set<RoleResponse> targetSet = new HashSet<>(roles);
        response.setRole(targetSet);
        return response;
    }
    public void updateUser(@MappingTarget User user, UserUpdateRequest request) {
            user.setFullName(request.getFullName());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            user.setPhoneNumber(request.getPhoneNumber());
            user.setAddress(request.getAddress());
        List<Role> roles = user.getRoles().stream().map((role) -> {
            Role resRole = new Role();
            resRole.setName(role.getName());
            resRole.setDescription(role.getDescription());
            resRole.setPermissions(role.getPermissions());
            return resRole;
        }).toList();
        Set<Role> targetSet = new HashSet<>(roles);
        user.setRoles(targetSet);
    }

}