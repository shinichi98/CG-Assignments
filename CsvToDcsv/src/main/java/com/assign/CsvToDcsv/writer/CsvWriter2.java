package com.assign.CsvToDcsv.writer;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;

import com.assign.CsvToDcsv.entity.Student;

public class CsvWriter2 extends FlatFileItemWriter<Student> {
	public CsvWriter2(String str) {
		super.setHeaderCallback(new FlatFileHeaderCallback() {
			@Override
            public void writeHeader(Writer writer) throws IOException {
                writer.write(Student.toStringw() + str);

            }

			
        });
//		this.setResource(file);
//    	DelimitedLineAggregator<Student> aggregator=new DelimitedLineAggregator<>();
//    	aggregator.setDelimiter("|");
//    	BeanWrapperFieldExtractor<Student> extractor=new BeanWrapperFieldExtractor<>();
//    	extractor.setNames(Student.fields());
//		aggregator.setFieldExtractor(extractor);
//		this.setLineAggregator(aggregator);
	}

}
