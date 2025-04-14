package nhom_java.skincarebookingsystem.configuration;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
//import nhom_java.skincarebookingsystem.enums.Role;
import nhom_java.skincarebookingsystem.models.Role;
import nhom_java.skincarebookingsystem.models.User;
import nhom_java.skincarebookingsystem.repositories.UserRepository;
import nhom_java.skincarebookingsystem.repositories.RoleReponsitory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.HashSet;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {
    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository, RoleReponsitory roleRepository) {
        return args -> {
            // Danh sách role mặc định
            String[][] defaultRoles = {
                    {"ADMIN", "Quản trị viên"},
                    {"MANAGER", "Quản lý"},
                    {"STAFF", "Nhân viên"},
                    {"SKIN_THERAPIST", "Chuyên viên da"},
                    {"USER", "Người dùng"}
            };

            for (String[] roleData : defaultRoles) {
                String roleName = roleData[0];
                String description = roleData[1];

                if (roleRepository.findByName(roleName).isEmpty()) {
                    Role role = Role.builder()
                            .name(roleName)
                            .description(description)
                            .permissions(new HashSet<>()) // Hoặc thêm permissions nếu có
                            .build();
                    roleRepository.save(role);
                }
            }
        };
    }

}

