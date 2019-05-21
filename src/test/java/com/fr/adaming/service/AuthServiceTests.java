package com.fr.adaming.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
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
public class AuthServiceTests {

	@Autowired
	private IUserService service;
	
	private User result;
	
	@Test
	public void createUser() {
		System.out.println("***************Start first test methode***************");
		User testUser = new User(null, "nom", "prenom", "email@email.fr", "azerty1234*", null);
		
		String result = service.create(testUser);
		System.out.println("DEBUG USER ID AFTER Creation:" +result.getId());
		
		String expectedResult = "SUCCESS";
		
//		assertEquals("un probleme d'ajout d'user", "SUCCES", result);
//		assertNotNull(result);
		
	}
	
	@Test
	public void deleteUser() {
		System.out.println("***************Start second test methode***************");
		System.out.println("DEBUG USER ID:" +result);
		service.deleteById(result.getId());
		
		
	}
	
	@Before
	public void beforeMethod() {
		System.out.println("***************before test methode***************");
	}
	
	@After
	public void afterMethod() {
		System.out.println("***************after test methode***************");
		
	
	}
	
}
