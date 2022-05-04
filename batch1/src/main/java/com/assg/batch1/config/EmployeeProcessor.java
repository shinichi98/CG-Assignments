package com.assg.batch1.config;

import org.springframework.batch.item.ItemProcessor;

import com.assg.batch1.entity.Employee;

public class EmployeeProcessor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(Employee item) throws Exception {
		return item;
	}

}
