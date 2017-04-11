package br.com.ProjetoPDS.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import br.com.ProjetoPDS.App.Controller.HomeController;
import br.com.ProjetoPDS.App.Service.ClienteService;
import br.com.ProjetoPDS.App.Service.OficinaService;

@SpringBootApplication
@ComponentScan(basePackageClasses={HomeController.class, ClienteService.class})
public class StartApplication {
	
	
	public static void main(String[] args){
		SpringApplication.run(StartApplication.class, args);
	}

}
