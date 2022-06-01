package com.assig.SoapAssig.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assig.soapassig.entity.Employee;
import com.assig.soapassig.repository.empRepo;

@Service
public class employeeServiceImpl implements EmployeeService {
	@Autowired
	private empRepo repo;

	@Override
	public void AddEmployee(Employee employee) {
		repo.save(employee);
	}

	@Override
	public Employee getEmployeeById(int empId) {
		return repo.findByEmployeeId(empId);
	}

	@Override
	public void updateEmployee(Employee employee) {
		repo.save(employee);
	}

	@Override
	public void deleteEmployee(int empId) {
		repo.deleteById(empId);
	}

}
