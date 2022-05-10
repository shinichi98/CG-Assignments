package com.assig.XmlToDb.writer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import com.assig.XmlToDb.entity.Person;

public class XmlWriter extends JdbcBatchItemWriter<Person>{

	public XmlWriter(DataSource dataSource) {
		this.setDataSource(dataSource);
		this.setSql("INSERT INTO person(personid,first_name,last_name,email,age) VALUES(?,?,?,?,?)");
		this.setItemPreparedStatementSetter(new ItemPreparedStatementSetter<Person>() {

			@Override
			public void setValues(Person item, PreparedStatement ps) throws SQLException {
				ps.setInt(1, item.getPersonId());
				ps.setString(2,item.getFirstName());
				ps.setString(3,item.getLastName());
				ps.setString(4,item.getEmail());
				ps.setInt(5, item.getAge());
				
			}
		});
	
	}
}
