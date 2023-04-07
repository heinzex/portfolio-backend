package service;

import interfaz.IService;
import java.util.List;
import model.Provincia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProvinciaRepository;

@Service
public class ProvinciaService implements IService<Provincia>  {
          @Autowired
           ProvinciaRepository Repo;     

       @Override
          public List<Provincia> traerLista() {
                    return Repo.findAll();
          }
          
          @Override
          public Object traer(Long id) {
                    return Repo.findById(id).orElse(null);
          }
          
          @Override
          public void crear(Provincia obj) {
                    Repo.save(obj);
          }
          
          @Override
          public boolean editar(Provincia obj) {
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
