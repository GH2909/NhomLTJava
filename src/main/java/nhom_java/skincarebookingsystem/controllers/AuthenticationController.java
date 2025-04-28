package nhom_java.skincarebookingsystem.controllers;

import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nhom_java.skincarebookingsystem.dto.request.*;
import nhom_java.skincarebookingsystem.dto.response.AuthenticationResponse;
import nhom_java.skincarebookingsystem.dto.response.IntrospectResponse;
import nhom_java.skincarebookingsystem.models.User;
import nhom_java.skincarebookingsystem.repositories.UserRepository;
import nhom_java.skincarebookingsystem.services.AuthenticationService;
import nhom_java.skincarebookingsystem.services.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.text.ParseException;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@CrossOrigin(origins = "*")
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        var result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request) throws JOSEException, ParseException {
        var result = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/refresh")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody RefreshRequest request)
            throws ParseException, JOSEException {
        var result = authenticationService.refreshToken(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping ("/logout")
    ApiResponse<Void> logout(@RequestBody LogoutRequest request) throws JOSEException, ParseException {
        authenticationService.logout(request);
        return ApiResponse.<Void>builder()
                .build();
    }

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody Map<String, String> request) {
        // Kiểm tra nếu request là null
        if (request == null) {
            return ResponseEntity.badRequest().body("Request body null");
        }

        // Kiểm tra xem request có chứa email không
        if (!request.containsKey("email")) {
            return ResponseEntity.badRequest().body("Request thiếu email");
        }

        // Lấy giá trị email từ request
        String email = request.get("email");

        // In ra email nhận được
        System.out.println("Email nhận được: " + email);

        // Kiểm tra nếu email có tồn tại trong cơ sở dữ liệu không
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.badRequest().body("Email không tồn tại.");
        }

        User user = optionalUser.get();
        String newPassword = generateRandomPassword();

        // In ra mật khẩu mới được tạo ra
        System.out.println("Mật khẩu mới được tạo ra: " + newPassword);

        // Mã hóa mật khẩu mới
        String encodedPassword = passwordEncoder.encode(newPassword); // Mã hóa mật khẩu mới
        user.setPassword(encodedPassword); // Cập nhật mật khẩu đã mã hóa

        // Lưu người dùng với mật khẩu mới vào cơ sở dữ liệu
        userRepository.save(user);

        // Gửi email chứa mật khẩu mới
        emailService.sendSimpleMessage(
                user.getEmail(),
                "Đặt lại mật khẩu Skincare Booking System",
                "Mật khẩu mới của bạn là: " + newPassword
        );
        System.out.println("Đã gửi email chứa mật khẩu mới đến email của người dùng.");
        return ResponseEntity.ok("Mật khẩu đã được gửi tới email của bạn.");
    }

    private String generateRandomPassword() {
        int length = 8;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

}