package service;

import interfaz.IService;
import java.util.List;
import model.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PaisRepository;

@Service
public class PaisService implements IService<Pais> {
          @Autowired
           PaisRepository Repo;
          
          @Override
          public List<Pais> traerLista() {
                    return Repo.findAll();
          }
          
          @Override
          public Object traer(Long id) {
                    return Repo.findById(id).orElse(null);
          }
          
          @Override
          public void crear(Pais obj) {
                    Repo.save(obj);
          }
          
          @Override
          public boolean editar(Pais obj) {
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
