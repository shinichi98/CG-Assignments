package com.assign.DbToRest.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assign.DbToRest.entity.Persons;

public interface personrepo extends JpaRepository<Persons, Integer> {
//	List<Persons> findAll();
	Persons findById(int id);
}
