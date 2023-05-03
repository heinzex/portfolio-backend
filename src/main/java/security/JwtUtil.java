package security;

import io.jsonwebtoken.*;
import java.util.Collections;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Component
public class JwtUtil {

          private final static String SECRET = "1f48936h6n8r5S4H984fbwe57t7i1";
          private final static long EXPIRATION_SECONDS = 360_000;

          public static String createToken(String nombre, String email) {
                    long expinationTime = EXPIRATION_SECONDS * 1_000;
                    Date expirationDate = new Date(System.currentTimeMillis() + expinationTime);
                    Map<String, Object> extra = new HashMap<>();

                    return Jwts.builder()
                            .setSubject(email)
                            .setExpiration(expirationDate)
                            .addClaims(extra)
                            .signWith(SignatureAlgorithm.HS512, SECRET.getBytes()) //Keys.hmacShaKeyFor(SECRET.getBytes())
                            .compact();
          }

          public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
                    try {
                              Claims claims = Jwts.parser()
                                      .setSigningKey(SECRET.getBytes())
                                      .parseClaimsJws(token)
                                      .getBody();

                              String email = claims.getSubject();

                              return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
                    } catch (JwtException e) {
                              return null;
                    }
          }

          public static String getEmail(String token) {
                    Claims claims = Jwts.parser()
                            .setSigningKey(SECRET.getBytes())
                            .parseClaimsJws(token)
                            .getBody();

                    String email = claims.getSubject();

                    return email;
          }
}
