package com.assig.XmlToDb.processor;

import org.springframework.batch.item.ItemProcessor;

import com.assig.XmlToDb.entity.Person;

public class PersonProcessor implements ItemProcessor<Person, Person> {

	@Override
	public Person process(Person item) throws Exception {
		if(item.getAge()>30) return item;
		else return null;
	}
	
}
