package nhom_java.skincarebookingsystem.controllers;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import nhom_java.skincarebookingsystem.dto.request.ApiResponse;
import nhom_java.skincarebookingsystem.dto.request.UserCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.UserUpdateRequest;
import nhom_java.skincarebookingsystem.dto.response.UserResponse;
import nhom_java.skincarebookingsystem.models.User;
import nhom_java.skincarebookingsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@Builder
@RestController
@RequestMapping("/users")
@FieldDefaults(level = AccessLevel.PRIVATE,  makeFinal = true)
public class UserController {

    @Autowired
      UserService userService;

    @PostMapping

    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.createUser(request))
                .build();


    }
    @GetMapping
    ApiResponse<List<UserResponse>> getUsers()
    {
        var authentication = SecurityContextHolder.getContext().getAuthentication() ;

        log.info("Email: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));

        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.getUsers())
                .build();
    }

    @GetMapping("/{email}")
    ApiResponse<UserResponse> getUser(@PathVariable String email){
        return ApiResponse.<UserResponse>builder()
                .result(userService.getUser(email))
                .build();
    }

    @GetMapping("/myInfo")
    ApiResponse<UserResponse> getMyInfo()
    {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.getMyInfo());
        return apiResponse;
    }

    @PutMapping("/{email}")
    ApiResponse<UserResponse> updateUser(@PathVariable String email, @RequestBody UserUpdateRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        return ApiResponse.<UserResponse>builder()
                .result(userService.updateUser(email, request))
                .build();
    }

}
