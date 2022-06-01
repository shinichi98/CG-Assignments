package com.Assign.MqAssign.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;

import com.Assign.MqAssign.entity.Employee;

public class amqpReader extends JdbcCursorItemReader<Employee>{
	
	public amqpReader(EmpMapper empMapper,DataSource dataSource) {
		this.setDataSource(dataSource);
		this.setSql("SELECT * FROM Employee");
		this.setRowMapper(empMapper);
	}

}
