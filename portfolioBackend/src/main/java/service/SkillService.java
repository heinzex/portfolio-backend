package service;

import interfaz.IService;
import java.util.List;
import model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SkillRepository;

@Service
public class SkillService implements IService<Skill>{
           @Autowired
            SkillRepository Repo;    

        @Override
          public List<Skill> traerLista() {
                    return Repo.findAll();
          }
          
          @Override
          public Object traer(Long id) {
                    return Repo.findById(id).orElse(null);
          }
          
          @Override
          public void crear(Skill obj) {
                    Repo.save(obj);
          }
          
          @Override
          public boolean editar(Skill obj) {
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
