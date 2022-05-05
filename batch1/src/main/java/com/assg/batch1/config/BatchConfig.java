package com.assg.batch1.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
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
import com.assg.batch1.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class BatchConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Bean
	public FlatFileItemReader<Employee> reader(){
		FlatFileItemReader<Employee> itemReader= new FlatFileItemReader<>();
		itemReader.setResource(new FileSystemResource("src/main/resources/Book1.csv"));
		itemReader.setName("csvReader");
		itemReader.setLinesToSkip(1);
	    itemReader.setLineMapper(lineMapper());
	    return itemReader;
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
	@Bean
	public EmployeeProcessor processor() {
		return new EmployeeProcessor();
	}
	@Bean
	public RepositoryItemWriter<Employee> writer(){
		RepositoryItemWriter<Employee> writer = new RepositoryItemWriter<>();
		writer.setRepository(employeeRepository);
		writer.setMethodName("save");
		return writer;
	}
	
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("csv-step").<Employee,Employee>chunk(50)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}
	@Bean
	public Job runJob() {
		return this.jobBuilderFactory.get("importEmployee")
				.flow(step1()).end().build();
	}
	
	
}

























