
package controller;

import model.AcercaDe;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.AcercaDeService;

@RestController
@RequestMapping("/api/acercade")
public class AcercaDeController extends PController<AcercaDe, AcercaDeService> {

}
