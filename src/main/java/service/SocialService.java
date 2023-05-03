package service;

import interfaz.IService;
import java.util.List;
import model.Social;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SocialRepository;

@Service
public class SocialService implements IService<Social> {

          @Autowired
          SocialRepository Repo;

          @Override
          public List<Social> traerLista() {
                    return Repo.findAll();
          }

          @Override
          public Object traer(Long id) {
                    return Repo.findById(id).orElse(null);
          }

          @Override
          public void crear(Social obj) {
                    Repo.save(obj);
          }

          @Override
          public boolean editar(Social obj) {
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
