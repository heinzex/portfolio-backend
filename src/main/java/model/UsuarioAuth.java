package model;

import java.util.Collection;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

@Getter @Setter
public class UsuarioAuth implements UserDetails{
          
          private String email;
          private String contraseña;
          private String token;

          @Override
          public Collection<? extends GrantedAuthority> getAuthorities() {
                     List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                            .commaSeparatedStringToAuthorityList("ROLE_USER");
                    return grantedAuthorities;
          }

          @Override
          public String getPassword() {
                    return contraseña;
          }

          @Override
          public String getUsername() {
                    return email;
          }

          @Override
          public boolean isAccountNonExpired() {
                    return true;
          }

          @Override
          public boolean isAccountNonLocked() {
                    return true;
          }

          @Override
          public boolean isCredentialsNonExpired() {
                    return true;
          }

          @Override
          public boolean isEnabled() {
                   return true;
          }
          
}
