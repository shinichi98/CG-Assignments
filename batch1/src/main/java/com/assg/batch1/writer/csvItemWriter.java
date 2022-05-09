package com.assg.batch1.writer;

import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.assg.batch1.entity.Employee;
import com.assg.batch1.repository.EmployeeRepository;

public class csvItemWriter extends RepositoryItemWriter<Employee> {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public csvItemWriter() {
		this.setRepository(employeeRepository);
		this.setMethodName("save");
	}

}
