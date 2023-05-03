package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Perfil {

          @Id
          @GeneratedValue(strategy = GenerationType.SEQUENCE)
          private Long id;
          private String nombre;
          private String fotoPerfil;
          private String fotoFondo;
          private String telefono;
          private String informacionExtra;
          private String pais;
          private String provincia;
          private String fechaNacimiento;
          private int edad;
          private String acercaDe;
          @JsonIgnore
          @JoinColumn(name = "user_id")
          @OneToOne
          private Usuario user; 
}

