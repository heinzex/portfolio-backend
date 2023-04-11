package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class ExpEdu {

          @Id
          @GeneratedValue(strategy = GenerationType.SEQUENCE)
          private Long Id;
          private String nombre;
          private Date tiempo;
          private String informacion;
          private String icono;
          private boolean esExp;
          @ManyToOne
          private Usuario user;
}
