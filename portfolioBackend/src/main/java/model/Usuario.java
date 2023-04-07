package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Usuario {

          @Id
          @GeneratedValue(strategy = GenerationType.SEQUENCE)
          private Long Id;
          private String usuario;
          private String contraseña;
          private String email;
          @OneToOne
          private AcercaDe acercaDe;
          @OneToOne
          private Perfil perfil;
          @OneToMany
          private List<ExpEdu> expEdu;
          @OneToMany
          private List<Skill> skill;
          @OneToMany
          private List<Proyecto> proyecto;
}
