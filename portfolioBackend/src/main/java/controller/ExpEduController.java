
package controller;

import model.ExpEdu;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ExpEduService;

@RestController
@RequestMapping("/api/expedu")
public class ExpEduController  extends PController<ExpEdu, ExpEduService>{
          
}
