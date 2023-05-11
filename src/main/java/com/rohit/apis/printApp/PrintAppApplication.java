package com.rohit.apis.printApp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrintAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrintAppApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {return new ModelMapper();
	}

}
