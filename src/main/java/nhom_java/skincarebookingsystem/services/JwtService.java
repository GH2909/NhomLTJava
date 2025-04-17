package nhom_java.skincarebookingsystem.services;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class JwtService {

    @Value("${jwt.signerKey}")
    private String SIGNER_KEY;

    /**
     * Trích xuất email (username) từ token
     */
    public String extractUsername(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            return signedJWT.getJWTClaimsSet().getSubject();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Kiểm tra token có hợp lệ không (chữ ký và thời gian)
     */
    public boolean isTokenValid(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            boolean verified = signedJWT.verify(new MACVerifier(SIGNER_KEY.getBytes()));
            Date expirationTime = signedJWT.getJWTClaimsSet().getExpirationTime();
            return verified && expirationTime != null && expirationTime.after(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Trích danh sách quyền từ claim "scope"
     */
    public List<String> extractAuthorities(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWTClaimsSet claimsSet = signedJWT.getJWTClaimsSet();
            String scope = claimsSet.getStringClaim("scope");
            if (scope == null || scope.isBlank()) return Collections.emptyList();
            return Arrays.asList(scope.split(" "));
        } catch (ParseException e) {
            return Collections.emptyList();
        }
    }

    /**
     * Trích toàn bộ claim nếu cần dùng thêm
     */
    public JWTClaimsSet extractAllClaims(String token) throws ParseException {
        SignedJWT signedJWT = SignedJWT.parse(token);
        return signedJWT.getJWTClaimsSet();
    }
}
