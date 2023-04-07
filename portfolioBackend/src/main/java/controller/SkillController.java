package controller;

import model.Skill;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.SkillService;

@RestController
@RequestMapping("/api/skill")
public class SkillController  extends PController<Skill, SkillService>{
          
}
