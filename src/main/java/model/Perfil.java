package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Perfil {

          @Id
          @GeneratedValue(strategy = GenerationType.SEQUENCE)
          private Long id;
          private String fotoPerfil;
          private String fotoFondo;
          private String telefono;
          private String informacionExtra;
          @OneToOne
          private Usuario user;
}
