package br.com.allpets.AllPets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class AllPetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllPetsApplication.class, args);
	}

}

