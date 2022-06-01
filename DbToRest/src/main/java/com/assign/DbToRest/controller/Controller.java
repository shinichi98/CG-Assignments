package com.assign.DbToRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assign.DbToRest.entity.Persons;
import com.assign.DbToRest.repository.personrepo;
import com.assign.DbToRest.service.PersonService;

@RestController
public class Controller {

	@Autowired
	private PersonService personService;
	@RequestMapping( path = "/per", produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public List<Persons> getAllPersons()
	    {
	        return personService.getPersons();
	    }
	@GetMapping( path = "/person/{id}", produces = { "application/json", "application/xml"})
	public Persons getCompanyById(@PathVariable(value = "id") int id)
	    {
	        return personService.getPerson(id);
	    }
}