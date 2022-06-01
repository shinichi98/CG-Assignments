package com.assign.CsvToDcsv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages={
"com.assign"})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class CsvToDcsvApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsvToDcsvApplication.class, args);
	}

}
