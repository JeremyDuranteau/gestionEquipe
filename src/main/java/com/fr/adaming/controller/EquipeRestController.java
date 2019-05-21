package com.fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.entity.Equipe;
import com.fr.adaming.service.IEquipeService;

@RestController
@RequestMapping(path = "api")
public class EquipeRestController {

	@Autowired
	private IEquipeService service;

	@RequestMapping(path = "/equipe", method = RequestMethod.POST)
	public void create(@RequestBody Equipe equipe) {
		service.create(equipe);
	}

	@RequestMapping(path = "/equipe/{id}", method = RequestMethod.GET)
	public Equipe readById(@PathVariable long id) {
		return service.readById(id);
	}

	@RequestMapping(path = "/equipe", method = RequestMethod.GET)
	public List<Equipe> readAll() {
		return service.readAll();
	}

	@RequestMapping(path = "/equipe", method = RequestMethod.PUT)
	public void update(@RequestBody Equipe equipe) {
		service.update(equipe);
	}

	@RequestMapping(path = "/equipe", method = RequestMethod.DELETE)
	public void delete(@RequestBody Equipe equipe) {
		
		service.delete(equipe);
	}
	
}
