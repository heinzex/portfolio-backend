package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExpEdu {

          @Id
          @GeneratedValue(strategy = GenerationType.SEQUENCE)
          private Long Id;
          private String nombre;
          private String tiempo;
          private String informacion;
          private String icono;
          private boolean esExp;
          @JsonIgnore
          @JoinColumn(name = "user_id")
          @ManyToOne
          private Usuario user;
}
