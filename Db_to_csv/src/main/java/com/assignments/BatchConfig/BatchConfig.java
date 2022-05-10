package com.assignments.BatchConfig;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.assignments.entity.Employee;
import com.assignments.processor.EmployeeProcessor;
import com.assignments.reader.EmpMapper;
import com.assignments.reader.csvItemReader;
import com.assignments.writer.csvItemWriter;


@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired 
	private DataSource dataSource;
	@Autowired 
	private EmpMapper empMapper;
	
	@Bean
	public csvItemReader reader(){
		return new csvItemReader(empMapper,dataSource);
	}

	@Bean
	public EmployeeProcessor processor() {
		return new EmployeeProcessor();
	}
	@Bean
	public csvItemWriter writer(){
		return new csvItemWriter();
	}
	
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("db-csv-step5").<Employee,Employee>chunk(10)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}
	@Bean
	public Job runJob() {
		return this.jobBuilderFactory.get("exportEmployee")
				.incrementer(new RunIdIncrementer())
				.start(step1()).build();
	}
	
	
}

























