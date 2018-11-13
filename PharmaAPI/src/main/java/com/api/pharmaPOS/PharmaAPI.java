package com.api.pharmaPOS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextException;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



@SpringBootApplication
@EnableJpaAuditing
public class PharmaAPI {

	public static void main(String[] args) throws ApplicationContextException {
		SpringApplication.run(PharmaAPI.class, args);
	}

}
