package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Pais {

          @Id
          @GeneratedValue(strategy = GenerationType.SEQUENCE)
          private Long id;
          private String nombre;
          @OneToMany
          private List<Provincia> provincia;
}
