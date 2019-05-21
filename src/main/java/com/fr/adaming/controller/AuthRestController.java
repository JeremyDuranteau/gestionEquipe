package com.fr.adaming.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.dto.LoginDto;
import com.fr.adaming.dto.RegisterDto;
import com.fr.adaming.entity.User;
import com.fr.adaming.service.IAuthService;


@RestController
@RequestMapping(path = "api")
public class AuthRestController {
	
	@Autowired
	private IAuthService service;
	
	@RequestMapping(path = "/auth", method = RequestMethod.POST)
	public User login(@Valid @RequestBody LoginDto loginDto) {
		User u =service.login(loginDto.getEmail(),loginDto.getPwd()); 
		return u;
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String register(@Valid @RequestBody RegisterDto dto) {
		
		User user = new User(null, dto.getNom(), dto.getPrenom(), dto.getEmail(), dto.getPwd(), null);
		User u=service.register(user);
		return u.getNom();
		
	}
}
