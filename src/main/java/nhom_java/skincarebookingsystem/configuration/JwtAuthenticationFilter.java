package nhom_java.skincarebookingsystem.configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import nhom_java.skincarebookingsystem.models.User;
import nhom_java.skincarebookingsystem.repositories.UserRepository;
import nhom_java.skincarebookingsystem.services.JwtService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        final String token;
        final String userEmail;

        // 1. Không có Authorization header hoặc không bắt đầu bằng "Bearer "
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        token = authHeader.substring(7);
        userEmail = jwtService.extractUsername(token);

        // 2. Đã có Authentication trong context -> bỏ qua
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            User user = userRepository.findByEmail(userEmail)
                    .orElse(null); // Không tìm thấy thì bỏ qua luôn

            if (user != null && jwtService.isTokenValid(token)) {
                List<String> roles = jwtService.extractAuthorities(token);
                var authorities = roles.stream()
                        .map(SimpleGrantedAuthority::new)
                        .toList();

                var authToken = new UsernamePasswordAuthenticationToken(user, null, authorities);
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
