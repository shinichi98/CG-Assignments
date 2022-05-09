package com.assg.batch1.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import com.assg.batch1.entity.Employee;


public class csvItemReader extends JdbcCursorItemReader<Employee>{
	
	public csvItemReader(EmpMapper empMapper,DataSource dataSource) {
		this.setDataSource(dataSource);
		this.setSql("SELECT * FROM Employee");
		this.setRowMapper(empMapper);
	}
}
