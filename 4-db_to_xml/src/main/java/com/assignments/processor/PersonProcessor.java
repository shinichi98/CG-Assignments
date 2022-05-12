package com.assignments.processor;

import org.springframework.batch.item.ItemProcessor;

import com.assignments.entity.Person;

public class PersonProcessor implements ItemProcessor<Person, Person> {

	@Override
	public Person process(Person item) throws Exception {
		return item;
	}
	
}
