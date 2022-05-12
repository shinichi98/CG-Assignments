package com.assignments.reader;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.jdbc.core.RowMapper;

import com.assignments.entity.Person;

public class dbreader extends JdbcCursorItemReader<Person> {
	
	public dbreader(DataSource dataSource) {
		this.setDataSource(dataSource);
		this.setSql("select * from person");
		this.setRowMapper(new RowMapper<Person>() {
			
			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person person=new Person();
				person.setPersonId(rs.getInt("personid"));
				person.setFirstName(rs.getString("first_name"));
				person.setLastName(rs.getString("last_name"));
				person.setEmail(rs.getString("email"));
				person.setAge(rs.getInt("age"));
				System.out.println(person);
				return person;
			}
		});
	}

}
