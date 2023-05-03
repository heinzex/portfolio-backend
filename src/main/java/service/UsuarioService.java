package service;

import interfaz.IService;
import java.util.List;
import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import repository.UsuarioRepository;

@Service
@Primary
public class UsuarioService implements IService<Usuario> {
          
          @Autowired
          UsuarioRepository Repo;
          
          @Override
          public List<Usuario> traerLista() {
                    return Repo.findAll();
          }
          
          @Override
          public Object traer(Long id) {
                    return Repo.findById(id).orElse(null);
          }
          
          @Override
          public void crear(Usuario obj) {
                    Repo.save(obj);
          }
          
          @Override
          public boolean editar(Usuario obj) {
                     if (Repo.findById(obj.getId()).orElse(null) != null) {
                              Repo.save(obj);
                              return true;
                    }
                    return false;
          }
          
          @Override
          public void eliminar(Long id) {
                    Repo.deleteById(id);
          }
          
          @Override
          public Usuario traerPorEmail(String user){
                    return Repo.findOneByEmail(user).orElse(null);
          }
          
}
