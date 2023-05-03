package controller;

import interfaz.IService;
import java.util.List;
import model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PController<T, S extends IService<T>> {
          
          @Autowired
          S inter;

          @GetMapping("/listar")
          public ResponseEntity<List<?>> traerLista() {
                  return new  ResponseEntity(inter.traerLista(),HttpStatus.OK);
          }

          @GetMapping("/traer")
          public ResponseEntity<Object> traer(@RequestParam Long id) {
                    return new  ResponseEntity( inter.traer(id),HttpStatus.OK);
          }

          @DeleteMapping("/eliminar")
          public ResponseEntity<String> eliminar(@RequestParam Long id) {
                    inter.eliminar(id);
                    return new  ResponseEntity(new Response("Eliminado con exito"),HttpStatus.OK);
          }
          
}
