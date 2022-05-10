package com.assignments.processor;

import org.springframework.batch.item.ItemProcessor;
import com.assignments.entity.Employee;

public class EmployeeProcessor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(Employee item) throws Exception {
		if(item.getGender().equals("male"))
		return item;
		else return null;
	}

}
