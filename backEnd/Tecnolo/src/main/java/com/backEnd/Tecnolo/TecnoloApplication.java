package com.backEnd.Tecnolo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class TecnoloApplication {
	public static void main(String[] args) {
		SpringApplication.run(TecnoloApplication.class, args);
	}

}
