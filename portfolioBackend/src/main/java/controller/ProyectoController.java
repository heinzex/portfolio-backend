package controller;

import model.Proyecto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ProyectoService;

@RestController
@RequestMapping("/api/proyecto")
public class ProyectoController  extends PController<Proyecto,ProyectoService >{
          
}
