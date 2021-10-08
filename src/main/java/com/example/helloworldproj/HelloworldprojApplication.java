package com.example.helloworldproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
//@Import({CorsConfig.class, TestDataLoader.class})
@Import({CorsConfig.class,HelloworldprojConfigurator.class})
public class HelloworldprojApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldprojApplication.class, args);
		System.out.println("visit http://127.0.0.1:8080/api/ resp. http://127.0.0.1:8080/browse/ in your browser");
	}

}
