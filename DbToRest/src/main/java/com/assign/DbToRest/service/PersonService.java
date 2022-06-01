package com.assign.DbToRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assign.DbToRest.entity.Persons;
import com.assign.DbToRest.repository.personrepo;

@Service
public class PersonService {

	@Autowired
	private personrepo repo;
	
	public List<Persons> getPersons(){
		  List<Persons> list=repo.findAll();
		  return list;
	  }
	public Persons getPerson(int id){
		  Persons person=repo.findById(id);
		  return person;
	  }
}
