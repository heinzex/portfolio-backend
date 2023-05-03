package security;

import java.util.Collection;
import java.util.Collections;
import lombok.AllArgsConstructor;
import model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails{

          private final Usuario user;
          
          @Override
          public Collection<? extends GrantedAuthority> getAuthorities() {
                   return Collections.emptyList();
          }

          @Override
          public String getPassword() {
                    return user.getContraseña();
          }

          @Override
          public String getUsername() {
                    return user.getEmail();
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
