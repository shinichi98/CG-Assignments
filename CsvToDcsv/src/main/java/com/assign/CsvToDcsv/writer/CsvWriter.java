package com.assign.CsvToDcsv.writer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;

import com.assign.CsvToDcsv.entity.Student;

public class CsvWriter implements ItemWriter<List<Student>> {

	@Override
	public void write(List<? extends List<Student>> items) throws Exception {
		List<Student> success=new ArrayList<Student>();
		List<Student> reject=new ArrayList<Student>();
		
		
		
			for(Student student : items.get(0))
			{
				if(student.getPercentage()>50)
				{
					
					success.add(student);
					
				} else
				{
					student.setRejectReason("percentage less than 50%");
					reject.add(student);

				}
			}
		
		System.out.println(success);
		System.out.println(reject);
		
	FlatFileItemWriter<Student> successWriter=new CsvWriter2("");
        successWriter.setResource(new FileSystemResource("src/main/resources/success_" + System.currentTimeMillis() + ".csv"));
        successWriter.setAppendAllowed(true);

        DelimitedLineAggregator<Student> lineAggregator = new DelimitedLineAggregator<>();
        lineAggregator.setDelimiter("|");

        BeanWrapperFieldExtractor<Student> fieldExtractor = new BeanWrapperFieldExtractor<>();
        fieldExtractor.setNames(Student.fields());

        lineAggregator.setFieldExtractor(fieldExtractor);
        successWriter.setLineAggregator(lineAggregator);
        successWriter.open(new ExecutionContext());
        successWriter.write(success);
        successWriter.setEncoding("UTF-8");
        successWriter.close();
        
        FlatFileItemWriter<Student> rejectWriter=new CsvWriter2("|rejectReason");
        rejectWriter.setResource(new FileSystemResource("src/main/resources/reject_" + System.currentTimeMillis() + ".csv"));
        rejectWriter.setAppendAllowed(true);
        DelimitedLineAggregator<Student> lineAggregatorReject = new DelimitedLineAggregator<>();
        lineAggregatorReject.setDelimiter("|");

        BeanWrapperFieldExtractor<Student> fieldExtractorReject = new BeanWrapperFieldExtractor<>();
        fieldExtractorReject.setNames(Student.fields());
        lineAggregatorReject.setFieldExtractor(fieldExtractorReject);
        rejectWriter.setLineAggregator(lineAggregatorReject);
        rejectWriter.open(new ExecutionContext());
        rejectWriter.write(reject);
        rejectWriter.setEncoding("UTF-8");
        rejectWriter.close();
		
	}

}
