package com.consultadiabeteapi.diabete;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Consulta de Diabetes API",
		version = "1", description = "API que devolve a chance de você estar com diabetes dipo 1 ou tipo 2"))
public class DiabeteApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiabeteApplication.class, args);
	}

}
