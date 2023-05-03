package service;

import interfaz.IService;
import java.util.List;
import model.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PerfilRepository;

@Service
public class PerfilService implements IService<Perfil>{
          @Autowired
           PerfilRepository Repo;
          
          @Override
          public List<Perfil> traerLista() {
                    return Repo.findAll();
          }
          
          @Override
          public Object traer(Long id) {
                    return Repo.findById(id).orElse(null);
          }
          
          @Override
          public void crear(Perfil obj) {
                    Repo.save(obj);
          }
          
          @Override
          public boolean editar(Perfil obj) {
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
}
