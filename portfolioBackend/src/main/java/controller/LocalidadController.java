package controller;

import model.Localidad;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.LocalidadService;

@RestController
@RequestMapping("/api/localidad")
public class LocalidadController  extends PController<Localidad, LocalidadService>{
          
}
