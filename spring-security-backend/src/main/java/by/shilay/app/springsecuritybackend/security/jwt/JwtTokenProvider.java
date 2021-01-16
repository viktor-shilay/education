package by.shilay.app.springsecuritybackend.security.jwt;

import by.shilay.app.springsecuritybackend.security.UserDetailsImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class JwtTokenProvider {

    @Value("${jwt.token.secretWord}")
    private String secretWord;

    @Value("${jwt.token.expirationTime}")
    private Long expirationTime;

    public String generateJwtToken(Authentication authentication) {
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, secretWord)
                .compact();
    }

    public String getEmailFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(secretWord).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretWord).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException expEx) {
            log.error("Token expired");
            throw new RuntimeException(expEx);
        } catch (UnsupportedJwtException unsEx) {
            log.error("Unsupported jwt");
            throw new RuntimeException(unsEx);
        } catch (MalformedJwtException mjEx) {
            log.error("Malformed jwt");
            throw new RuntimeException(mjEx);
        } catch (SignatureException sEx) {
            log.error("Invalid signature");
            throw new RuntimeException(sEx);
        } catch (Exception ex) {
            log.error("Invalid token");
            throw new RuntimeException(ex);
        }
    }
}
