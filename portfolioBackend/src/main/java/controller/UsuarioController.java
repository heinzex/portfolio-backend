package controller;

import model.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController extends PController<Usuario, UsuarioService>{//implements IController<Usuario> {

//          @Autowired
//          IService<Usuario> inter;
//
//          @Override
//          public List<Usuario> traerLista() {
//                    return inter.traerLista();
//          }
//
//          @Override
//          public Object traer(Long id) {
//                    return inter.traer(id);
//          }
//
//          @Override
//          public String crear(Usuario obj) {
//                    inter.crear(obj);
//                    return "Creado con exito.";
//          }
//
//          @Override
//          public String editar(Usuario obj) {
//                    if (inter.editar(obj)) {
//                              return "Creado con exito.";
//                    } else {
//                              return "No existe el elemento con el ID introducido";
//                    }
//          }
//
//          @Override
//          public void eliminar(Long id) {
//                    inter.eliminar(id);
//          }

}
