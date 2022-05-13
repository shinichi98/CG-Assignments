package com.assig.XmlToDb.reader;

import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.assig.XmlToDb.entity.Person;

public class XmlReader extends StaxEventItemReader<Person> {
	public XmlReader() {
		this.setResource(new ClassPathResource("persons.xml"));
		this.setFragmentRootElementName("person");
		Jaxb2Marshaller marshaller=new Jaxb2Marshaller();
    	marshaller.setClassesToBeBound(com.assig.XmlToDb.entity.Person.class);
    	this.setUnmarshaller(marshaller);
	}

}
