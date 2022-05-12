package com.assig.XmlToDb.reader;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.assig.XmlToDb.entity.Person;

public class XmlReader extends StaxEventItemReader<Person> {
	public XmlReader() {
		this.setResource(new ClassPathResource("persons.xml"));
		this.setFragmentRootElementName("person");
		Jaxb2Marshaller marshaller=new Jaxb2Marshaller();
		Map<String,String> map=new HashMap<String,String>();
    	map.put("person","com.assig.XmlToDb.entity.Person");
    	marshaller.setMappedClass(com.assig.XmlToDb.entity.Person.class);
    	marshaller.setClassesToBeBound(com.assig.XmlToDb.entity.Person.class);
    	this.setUnmarshaller(marshaller);
	}

}
