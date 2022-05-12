package com.assignments.writer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.assignments.entity.Person;

public class XmlWriter extends StaxEventItemWriter<Person> {
	public XmlWriter() {
		this.setResource(new FileSystemResource("src/main/resources/Person.xml"));
		XStreamMarshaller marshaller=new XStreamMarshaller();
		Map<String,String> map=new HashMap<String,String>();
    	map.put("Person","com.assignments.entity.Person");
    	marshaller.setAliases(map);
    	this.setOverwriteOutput(true);
  	  	this.setRootTagName("Persons");
    	this.setMarshaller(marshaller);
	}

}
