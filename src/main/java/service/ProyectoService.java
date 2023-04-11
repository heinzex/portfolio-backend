
package service;

import interfaz.IService;
import java.util.List;
import model.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProyectoRepository;

@Service
public class ProyectoService implements IService<Proyecto> {
            @Autowired
            ProyectoRepository Repo;     

         @Override
          public List<Proyecto> traerLista() {
                    return Repo.findAll();
          }
          
          @Override
          public Object traer(Long id) {
                    return Repo.findById(id).orElse(null);
          }
          
          @Override
          public void crear(Proyecto obj) {
                    Repo.save(obj);
          }
          
          @Override
          public boolean editar(Proyecto obj) {
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
