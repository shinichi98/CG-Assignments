package com.assignments.writer;

import org.springframework.batch.item.data.RepositoryItemWriter;

import com.assignments.entity.Employee;
import com.assignments.repository.EmployeeRepository;

public class csvItemWriter extends RepositoryItemWriter<Employee> {
	
	public csvItemWriter(EmployeeRepository employeeRepository) {
		this.setRepository(employeeRepository);
		this.setMethodName("save");
	}

}
