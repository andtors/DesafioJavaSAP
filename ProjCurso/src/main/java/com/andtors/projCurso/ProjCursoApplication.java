package com.andtors.projCurso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProjCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjCursoApplication.class, args);
	}

}
