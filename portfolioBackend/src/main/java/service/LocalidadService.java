package service;

import interfaz.IService;
import java.util.List;
import model.Localidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.LocalidadRepository;

@Service
public class LocalidadService  implements IService<Localidad>{
          @Autowired
           LocalidadRepository Repo;

       @Override
          public List<Localidad> traerLista() {
                    return Repo.findAll();
          }
          
          @Override
          public Object traer(Long id) {
                    return Repo.findById(id).orElse(null);
          }
          
          @Override
          public void crear(Localidad obj) {
                    Repo.save(obj);
          }
          
          @Override
          public boolean editar(Localidad obj) {
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
