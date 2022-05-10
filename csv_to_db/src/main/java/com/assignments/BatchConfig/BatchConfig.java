package com.assignments.BatchConfig;

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
import com.assignments.reader.csvItemReader;
import com.assignments.repository.EmployeeRepository;
import com.assignments.writer.csvItemWriter;


@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Bean
	public csvItemReader reader(){
		return new csvItemReader();
	}

	@Bean
	public EmployeeProcessor processor() {
		return new EmployeeProcessor();
	}
	@Bean
	public csvItemWriter writer(){
		return new csvItemWriter(employeeRepository);
	}
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("csv-step2").<Employee,Employee>chunk(10)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}
	@Bean
	public Job runJob() {
		return this.jobBuilderFactory.get("importEmployee")
				.incrementer(new RunIdIncrementer())
				.start(step1()).build();
	}
	
	
}

























