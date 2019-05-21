package com.fr.adaming.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.IUserDao;
import com.fr.adaming.entity.User;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao dao;

	private Logger log = Logger.getLogger(UserService.class);
	
	@Override
	public User create(User user) {
		User u =null;
		if(user==null) {
			return null;			
		}
		
		if(user.getId() == null || user.getId()==0) {
			try {
				u = dao.save(user);
				
			} catch (Exception  e) {
				e.printStackTrace();
				log.error("email existe deja");
			}
			log.debug("Create car ID non existant");
		}else {
			if(dao.existsById(user.getId())) {
				log.debug("L'objet User a un ID différent de null");
			}
			else {
				u = dao.save(user);
				log.info("L'utilisateur a été créé avec succès");
			}
		}
		return u;
		
	}

	@Override
	public User readById(Long id) {
		log.debug("ID in service layer : "+id);
		User res = null;
		try {
			res = dao.findById(id).get();
		} catch (Exception e) {
			if(e instanceof IllegalArgumentException) {
				log.info("ID est null ! Opération non effectuée");
			} else {
				e.printStackTrace();
				log.error(e.getMessage());
			}
		}
		return res;
		
	}

	@Override
	public List<User> readAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void update(User user) {
		if(user.getId() == null) {
			log.info("id non existant");
		}else {
			if(dao.existsById(user.getId())) {
				dao.save(user);
				log.info("MAJ du USER");
			}else {
				log.error("MAJ non possible");
			}
		}
		
		
	}

	@Override
	public boolean deleteById(Long id) {
		if(id != null && dao.existsById(id) == true) {
			dao.deleteById(id);
			return true;
		}else{
		return false;
	}
		
		
		
		// TODO Auto-generated method stub
//		System.out.println("serv"+id);
//		if(id != null) {
//			try {
//				dao.deleteById(id);
//				System.out.println("tar"+id);		
//			} catch (Exception e) {
//				e.printStackTrace();
//				log.error("l'id pas trouvé");
//			}
//		}else {
//			log.info("l'id est incorrect");
//		}
//		return "user delete";
//		
	}
	
	
}
