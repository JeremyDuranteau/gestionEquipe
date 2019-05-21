package com.fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.IUserDao;
import com.fr.adaming.entity.User;

@Service
public class AuthService implements IAuthService {

	@Autowired
	private IUserDao dao;
	
	@Override
	public User login(String email, String pwd) {
		// TODO Auto-generated method stub
		return dao.findByEmailandPwd(email, pwd);
	}

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		return dao.save(user);
	}

}
