package controller;

import interfaz.IService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PController<T, S extends IService<T>> {
          
          @Autowired
          S inter;

          @GetMapping("/listar")
          public List<?> traerLista() {
                    return inter.traerLista();
          }

          @GetMapping("/traer")
          public Object traer(@RequestParam Long id) {
                    return inter.traer(id);
          }

          @PostMapping("/crear")
          public String crear(@RequestBody T obj) {
                    inter.crear(obj);
                    return "Creado con exito.";
          }

          @PutMapping("/editar")
          public String editar(@RequestBody T obj) {
                    if (inter.editar(obj)) {
                              return "Creado con exito.";
                    } else {
                              return "No existe el elemento con el ID introducido";
                    }
          }

          @DeleteMapping("/eliminar")
          public void eliminar(@RequestParam Long id) {
                    inter.eliminar(id);
          }
}
