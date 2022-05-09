package com.assg.batch1.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;

import com.assg.batch1.entity.Employee;


public class csvItemReader extends FlatFileItemReader<Employee>{
	public csvItemReader() {
		this.setResource(new FileSystemResource("src/main/resources/Book1.csv"));
		this.setName("csvReader");
		this.setLinesToSkip(1);
	    this.setLineMapper(lineMapper());
	}
	
	private LineMapper<Employee> lineMapper() {
        DefaultLineMapper<Employee> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("EmpID","FIRST_NAME","LAST_NAME","CONTACT","DOJ","SALARY","DEPARTMENT_ID","GENDER");

        BeanWrapperFieldSetMapper<Employee> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Employee.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
        }
}
