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

@Getter
@Setter
@Entity
public class Social {

          @Id
          @GeneratedValue(strategy = GenerationType.SEQUENCE)
          private Long Id;
          private String instagram;
          private String facebook;
          private String twitter;
          private String youtube;
          @JsonIgnore
          @JoinColumn(name = "user_id")
          @OneToOne
          private Usuario user;

}
