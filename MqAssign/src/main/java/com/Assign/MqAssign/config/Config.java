package com.Assign.MqAssign.config;

import javax.sql.DataSource;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.amqp.AmqpItemReader;
import org.springframework.batch.item.amqp.AmqpItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Assign.MqAssign.entity.Employee;
import com.Assign.MqAssign.reader.EmpMapper;
import com.Assign.MqAssign.reader.amqpReader;
import com.Assign.MqAssign.rmqconfig.amqpConfig;


@Configuration
@EnableBatchProcessing
public class Config {
	
	@Autowired
    private StepBuilderFactory stepBuilderFactory;
	@Autowired 
	private DataSource dataSource;
	@Autowired 
	private EmpMapper empMapper;
	@Autowired
	private RabbitTemplate template;
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    
    @Bean
    public JdbcCursorItemReader<Employee> customerItemReader() {
    	
    	return new amqpReader(empMapper,dataSource);
    }
    
    @Bean
    public AmqpItemWriter<Employee> amqpWriter(){
        AmqpItemWriter<Employee> amqpItemWriter = new AmqpItemWriter<>(template);
        return amqpItemWriter;
    }
        
    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Employee, Employee>chunk(10)
                .reader(customerItemReader())
                .writer(amqpWriter())
                .build();
    }
    
    @Bean
    public Job job(){
        return jobBuilderFactory.get("job")
        		.incrementer(new RunIdIncrementer())
                .start(step1())
                .build();
    }
}

