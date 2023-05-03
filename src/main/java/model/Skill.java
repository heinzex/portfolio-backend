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
public class Skill {

          @Id
          @GeneratedValue(strategy = GenerationType.SEQUENCE)
          private Long Id;
          private String sector;
          private double porcentaje;
          @JsonIgnore
          @JoinColumn(name = "user_id")
          @ManyToOne
          private Usuario user;
}
