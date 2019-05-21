package com.fr.adaming.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fr.adaming.entity.User;

public interface IUserService {
	
	public User create(User user);
	public User readById (Long id);
	public List<User> readAll();
	public void update(User user);
	public boolean deleteById(Long id);
	
	
}
