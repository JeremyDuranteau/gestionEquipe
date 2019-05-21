package com.fr.adaming.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.IEquipeDao;
import com.fr.adaming.entity.Equipe;

@Service
public class EquipeService implements IEquipeService{

	@Autowired
	private IEquipeDao dao;
	
	private Logger log = Logger.getLogger(EquipeService.class);
	
	
	@Override
	public void create(Equipe equipe) {
		
		dao.save(equipe);
	}

	@Override
	public Equipe readById(long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public List<Equipe> readAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void update(Equipe equipe) {
		// TODO Auto-generated method stub
		dao.save(equipe);
	}

	@Override
	public void delete(Equipe equipe) {
		// TODO Auto-generated method stub
		dao.delete(equipe);
		
	}

}
