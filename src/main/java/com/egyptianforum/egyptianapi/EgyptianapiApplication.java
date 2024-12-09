package com.egyptianforum.egyptianapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.egyptianforum")
@OpenAPIDefinition(info = @Info(title = "My API", version = "v1", description = "Описание вашего API"))
public class EgyptianapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EgyptianapiApplication.class, args);
	}

}
