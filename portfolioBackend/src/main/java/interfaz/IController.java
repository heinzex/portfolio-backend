package interfaz;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IController<T> {
          
          @GetMapping("/listar")
          public List<T> traerLista();

          @GetMapping("/traer")
          public Object traer(@RequestParam Long id);

          @PostMapping("/crear")
          public String crear(@RequestParam T obj);

          @PutMapping("/editar")
          public String editar(@RequestParam T obj);

          @DeleteMapping("/eliminar")
          public void eliminar(@RequestParam Long id);

}
