package controller;

import model.Response;
import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import security.JwtUtil;
import service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController extends PController<Usuario, UsuarioService> {

          @Autowired
          UsuarioService inter;

          @GetMapping("/traerEmail")
          public Usuario traerPorMail(@RequestHeader String Authorization) {
                    String token = Authorization.replace("Bearer ", "");
                    String email = JwtUtil.getEmail(token);
                    Usuario user = inter.traerPorEmail(email);
                    return user;
          }

          @PutMapping("/editar")
          public ResponseEntity<Response> editar(@RequestBody Usuario user) {
                    if (inter.editar(user)) {
                              return new ResponseEntity(new Response("Editado con exito"), HttpStatus.OK);
                    } else {
                              return new ResponseEntity(new Response("No existe el elemento con el ID introducido"), HttpStatus.NOT_FOUND);
                    }
          }
}
