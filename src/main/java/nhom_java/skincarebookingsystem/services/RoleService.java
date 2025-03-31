package nhom_java.skincarebookingsystem.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import nhom_java.skincarebookingsystem.dto.request.RoleRequest;
import nhom_java.skincarebookingsystem.dto.response.RoleResponse;
import nhom_java.skincarebookingsystem.mapper.RoleMapper;
import nhom_java.skincarebookingsystem.repositories.PermissionRepository;
import nhom_java.skincarebookingsystem.repositories.RoleReponsitory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    RoleReponsitory roleReponsitory;
    PermissionRepository permissionRepository;
    RoleMapper roleMapper;

    public RoleResponse create(RoleRequest request) {
        var role = roleMapper.toRole(request);

        var permissions= permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        role = roleReponsitory.save(role);
        return roleMapper.toRoleResponse(role);
    }
    public List<RoleResponse> getAll(){
        return  roleReponsitory.findAll()
                .stream()
                .map(roleMapper::toRoleResponse)
                .toList();
    }
    public void delete(String role) {
        roleReponsitory.deleteById(role);
    }
}
