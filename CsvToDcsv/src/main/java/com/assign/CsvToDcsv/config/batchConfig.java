package com.assign.CsvToDcsv.config;


import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;

import com.assign.CsvToDcsv.classifier.StudentClassifier;
import com.assign.CsvToDcsv.entity.Student;
import com.assign.CsvToDcsv.processor.MapProcessor;
import com.assign.CsvToDcsv.processor.StudentProcessor;
import com.assign.CsvToDcsv.reader.CsvReader;
import com.assign.CsvToDcsv.reader.CsvReader2;
import com.assign.CsvToDcsv.writer.CsvWriter;
import com.assign.CsvToDcsv.writer.CsvWriter2;
import com.assign.CsvToDcsv.writer.cwriter;

@Configuration
@EnableBatchProcessing
public class batchConfig {
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public CsvReader reader(){
		return new CsvReader();
		
	}
	@Bean
	public CsvWriter writer(){
		return new CsvWriter();
	}

    @Bean
    public Step step1() {
   	 return stepBuilderFactory.get("Read_First_File").<List<Student>,List<Student>>chunk(1).reader(reader()).writer(writer()).build();
    }
    @Bean
    public Job job() {
   	 return jobBuilderFactory.get("csv-job").flow(step1()).end().build();
    }

	
}
