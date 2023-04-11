package service;

import interfaz.IService;
import java.util.List;
import model.ExpEdu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ExpEduRepository;

@Service
public class ExpEduService implements IService<ExpEdu> {

          @Autowired
          ExpEduRepository Repo;

          @Override
          public List<ExpEdu> traerLista() {
                    return Repo.findAll();
          }

          @Override
          public Object traer(Long id) {
                    return Repo.findById(id).orElse(null);
          }

          @Override
          public void crear(ExpEdu obj) {
                    Repo.save(obj);
          }

          @Override
          public boolean editar(ExpEdu obj) {
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
