package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Localidad {

          @Id
          @GeneratedValue(strategy = GenerationType.SEQUENCE)
          private Long id;
          private String nombre;
          @ManyToOne
          private Provincia provincia;
}
