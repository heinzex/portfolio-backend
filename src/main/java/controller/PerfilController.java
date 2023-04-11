package controller;

import model.Perfil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PerfilService;

@RestController
@RequestMapping("/api/perfil")
public class PerfilController extends PController<Perfil, PerfilService>{
          
}
