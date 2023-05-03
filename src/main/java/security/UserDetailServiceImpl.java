package security;

import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import repository.UsuarioRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
 
          @Autowired
          private UsuarioRepository repo;

          @Override
          public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                    Usuario user = repo
                            .findOneByEmail(username)
                            .orElseThrow(() -> new UsernameNotFoundException("El usuario no fue encontrado"));
                    
                    return new UserDetailsImpl(user);
          }
          
          
}
