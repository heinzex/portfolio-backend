package controller;

import model.Response;
import model.Skill;
import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import security.JwtUtil;
import service.SkillService;
import service.UsuarioService;

@RestController
@RequestMapping("/api/skill")
public class SkillController extends PController<Skill, SkillService> {

          @Autowired
          UsuarioService serv;

          @PostMapping("/crear")
          public ResponseEntity<Response> crear(@RequestBody Skill obj, @RequestHeader String Authorization) {
                    Usuario user = serv.traerPorEmail(JwtUtil.getEmail(Authorization.replace("Bearer ", "")));
                    obj.setUser(user);
                    inter.crear(obj);
                    return new ResponseEntity(new Response( "Creado con exito."), HttpStatus.OK);
          }
          
          @PutMapping("/editar")
          public ResponseEntity<Response> editar(@RequestBody Skill obj, @RequestHeader String Authorization) {
                    Usuario user = serv.traerPorEmail(JwtUtil.getEmail(Authorization.replace("Bearer ", "")));
                    obj.setUser(user);
                    if (inter.editar(obj)) {
                              return new ResponseEntity(new Response("Editado con exito"), HttpStatus.OK);
                    } else {
                              return new ResponseEntity(new Response("No existe el elemento con el ID introducido"), HttpStatus.NOT_FOUND);
                    }
          }
}
