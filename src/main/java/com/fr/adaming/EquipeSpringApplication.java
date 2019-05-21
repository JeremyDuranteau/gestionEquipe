package com.fr.adaming;



import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fr.adaming.entity.Equipe;
import com.fr.adaming.entity.User;
import com.fr.adaming.service.IEquipeService;
import com.fr.adaming.service.IUserService;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EquipeSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(EquipeSpringApplication.class, args);
	
		 User u = new User(5L, "nom", "prenom", "email", "pwd", null );
		 context.getBean(IUserService.class).create(u);
		 
		 Equipe e = new Equipe(6L, "nom", 1, "niveau");
		 context.getBean(IEquipeService.class).create(e);
		 
		 Logger log = Logger.getLogger(EquipeSpringApplication.class);
		 log.trace("Message de log (trace)");
		 log.debug("Message de log (debug)");
		 log.info("Message de log (info)");
		 log.warn("Message de log (warn)");
		 log.error("Message de log (error)");
		 log.fatal("Message de log (fatal)");
	}

}
