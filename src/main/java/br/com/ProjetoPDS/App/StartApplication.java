package br.com.ProjetoPDS.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import br.com.ProjetoPDS.App.Controller.HomeController;

@SpringBootApplication
@ComponentScan(basePackageClasses={HomeController.class})
public class StartApplication {
	
	public static void main(String[] args){
		
		SpringApplication.run(StartApplication.class, args);
	}
}
