package com.pruebasjpa.pruebasjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"security", "controller", "service", "model", "repository", "config"})
@EntityScan("model")
@EnableJpaRepositories("repository")
public class PruebasjpaApplication {

          public static void main(String[] args) {
                    SpringApplication.run(PruebasjpaApplication.class, args);
          }
}
