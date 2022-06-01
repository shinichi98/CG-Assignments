package com.assig.SoapAssig.Service;

import com.assig.soapassig.entity.Employee;

public interface EmployeeService {
	void AddEmployee(Employee employee);
	 
	 Employee getEmployeeById(int empId);
	 
    void updateEmployee(Employee employee);
    
    void deleteEmployee(int empId);

}
