package controller;

import model.Provincia;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ProvinciaService;

@RestController
@RequestMapping("/api/provincia")
public class ProvinciaController  extends PController<Provincia, ProvinciaService>{
          
}
