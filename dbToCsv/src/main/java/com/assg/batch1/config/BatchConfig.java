package com.assg.batch1.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.assg.batch1.entity.Employee;
import com.assg.batch1.processor.EmployeeProcessor;
import com.assg.batch1.reader.EmpMapper;
import com.assg.batch1.reader.csvItemReader;
import com.assg.batch1.repository.EmployeeRepository;
import com.assg.batch1.writer.csvItemWriter;

import lombok.AllArgsConstructor;

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

























