package com.assig.XmlToDb.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.assig.XmlToDb.entity.Person;
import com.assig.XmlToDb.processor.PersonProcessor;
import com.assig.XmlToDb.reader.XmlReader;
import com.assig.XmlToDb.writer.XmlWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public PersonProcessor processor(){
		return new PersonProcessor();
	}
	
	@Bean
	public StaxEventItemReader<Person> reader(){
		return new XmlReader();
	}
	@Bean
	public JdbcBatchItemWriter<Person> writer(){
		return new XmlWriter(dataSource);
	}
	@Bean
	public Step step1(){
		return stepBuilderFactory.get("step1").<Person,Person>chunk(10)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}

	@Bean
	public Job exportPerosnJob(){
		return jobBuilderFactory.get("importPersonJob")
				.incrementer(new RunIdIncrementer())
				.start(step1())
				.build();
	}
}
