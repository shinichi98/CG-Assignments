package com.assignments.writer;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;

import com.assignments.entity.Employee;



public class csvItemWriter extends FlatFileItemWriter<Employee> {
	
	public csvItemWriter() {
		this.setResource(new FileSystemResource("src/main/resources/Outsource.csv"));
		this.setLineAggregator(aggregator());
			
	}
	public DelimitedLineAggregator<Employee> aggregator(){
		DelimitedLineAggregator<Employee> lineaggregator=new DelimitedLineAggregator<>();
		lineaggregator.setDelimiter(",");
		BeanWrapperFieldExtractor<Employee> fieldExtractor=new BeanWrapperFieldExtractor<>();
		fieldExtractor.setNames(new String[] {"empid","firstName","lastName","contact","doj","salary","department_id","gender"});
		lineaggregator.setFieldExtractor(fieldExtractor);
		return lineaggregator;	
	}
}
