package controller;

import model.Pais;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PaisService;

@RestController
@RequestMapping("/api/pais")
public class PaisController  extends PController<Pais, PaisService>{
          
}
