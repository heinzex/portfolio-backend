package service;

import interfaz.IService;
import java.util.List;
import model.AcercaDe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AcercaDeRepository;

@Service
public class AcercaDeService implements IService<AcercaDe> {

          @Autowired
          AcercaDeRepository Repo;

          @Override
          public List<AcercaDe> traerLista() {
                    return Repo.findAll();
          }

          @Override
          public Object traer(Long id) {
                    return Repo.findById(id).orElse(null);
          }

          @Override
          public void crear(AcercaDe obj) {
                    Repo.save(obj);
          }

          @Override
          public boolean editar(AcercaDe obj) {
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
