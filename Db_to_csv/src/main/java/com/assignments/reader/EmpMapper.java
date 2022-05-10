package com.assignments.reader;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.assignments.entity.Employee;

@Component
public class EmpMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee=new Employee();
		employee.setEmpid(rs.getInt("empid"));
		employee.setFirstName(rs.getString("first_name"));
		employee.setLastName(rs.getString("last_name"));
		employee.setDepartment_id(rs.getInt("department_id"));
		employee.setContact(rs.getString("contact"));
		employee.setDoj(rs.getString("doj"));
		employee.setGender(rs.getString("gender"));
		employee.setSalary(rs.getInt("salary"));
		return employee;
	}
	

}
