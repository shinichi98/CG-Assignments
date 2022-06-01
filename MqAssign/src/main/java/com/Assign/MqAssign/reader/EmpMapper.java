package com.Assign.MqAssign.reader;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.Assign.MqAssign.entity.Employee;

@Component
public class EmpMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee=new Employee();
		employee.setEmpid(rs.getInt("empid"));
		employee.setName(rs.getString("name"));
		employee.setContact(rs.getString("contact"));
		return employee;
	}
	

}