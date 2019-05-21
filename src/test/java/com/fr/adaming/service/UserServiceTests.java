package com.fr.adaming.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fr.adaming.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTests {

	@Autowired
	private IUserService service;
	
	private static User result; 
	// mettre en statique afin de pouvoir prendre ce parametre dans chaque methode
	
	@Test
	public void aa_createUserNull() {
		System.out.println("**********first test methode***************");
		User user= null;
		result = service.create(user);
		assertNull(result); 
	}
	
	
	@Test
	public void ab_createUserZero() {
		System.out.println("**********second test methode***************");
		User user= new User(0L, "nom", "prenom", "email", "pwd", null);
		
		result = service.create(user);
		assertNotNull(result.getId());
	}
	
	@Test
	public void ac_createUserExist() {
		System.out.println("**********third test methode id***************");
		// creer deux users qui ont le meme ID
		User user= new User(2L, "nom", "prenom", "rf@email", "pwd", null);
		result = service.create(user);
		User usera= new User(2L, "nom", "prenom", "@email", "pwd", null);
		User result1 = service.create(usera);
		// tester le deuxieme utilisateur pour regarder si il rentre avec le meme id que l'user1
		assertNull(result1); 
	}
		
	@Test
	public void ad_createUserExistEmail() {	
		System.out.println("**********for test methode email***************");
		// creer deux users qui ont le meme EMAIL
		User user= new User(3L,"nom", "prenom", "Test@email", "pwd", null);
		result = service.create(user);
		User usera= new User(4L,"nom", "prenom", "Test@email", "pwd", null);
		User result1 = service.create(usera);
		// tester l'userC pour regarder si il rentre avec le meme EMAIL que l'userB
		assertNull(result1); 
	}
	
	@Test
	public void ae_readByID() {
		System.out.println("************five test methode***********");
		// regarder que l'id ne soit pas egal a null
		User user= new User(null, "nom", "prenom", "email", "pwd", null);
		user = service.create(user);
		result = service.readById(user.getId());
		assertNotNull(result); 
		
	}
	@Test
	public void af_readByIDNull() {
		System.out.println("************six test methode***********");
		// regarder que l'id egal a null
		result = service.readById(null);
		assertNull(result); 
		
	}
	
	@Test
	public void af_deleteById() {
		// regarder si ID existe
		System.out.println("*************seven test methode*************");
		User user= new User(5L, "fre", "rfe", "@gmail", "ged", null);
		user = service.create(user);
		boolean result = service.deleteById(user.getId());
		assertTrue(result);
	}
	
	@Test
	public void ag_deleteById() {
		// regarder si ID egal null
		System.out.println("*************eight test methode*************");
		boolean result = service.deleteById(null);
		assertTrue(result);
	}
	@After
	public void afterMethode() {
		System.out.println("************Apres methode***********");
		if(result != null && result.getId() != null) {
			service.deleteById(result.getId());
			
		}
	}

	
}
