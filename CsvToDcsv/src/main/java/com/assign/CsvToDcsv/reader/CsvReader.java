package com.assign.CsvToDcsv.reader;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.assign.CsvToDcsv.entity.Student;

public class CsvReader implements ItemReader<List<Student>>{
	List<Student> processedList=new  ArrayList<Student>();
	private boolean isComplete=false;
	@Override
	public List<Student> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (isComplete) return null;
		Map<Integer,Student> map=new HashMap<Integer,Student>();
			Stream<String> mappingStream=Files.lines(Paths.get("C:\\Users\\utyadav\\Documents\\parallel\\github\\CG-Assignments\\CsvToDcsv\\src\\main\\resources\\previous.csv"),StandardCharsets.UTF_8 );
			List<String> currentList=mappingStream.collect(Collectors.toList());
		    for (int i = 1; i<currentList.size(); i++) {
		        	String str[] = currentList.get(i).split("\\|");
			        Student student=stbuilder(str);
			        map.put(student.getId(), student);
			}
		    mappingStream.close();
		    Stream<String> mappingStream2=Files.lines(Paths.get("C:\\Users\\utyadav\\Documents\\parallel\\github\\CG-Assignments\\CsvToDcsv\\src\\main\\resources\\current.csv"),StandardCharsets.UTF_8 );
			currentList=mappingStream2.collect(Collectors.toList());
		    for (int i = 1; i<currentList.size(); i++) {
	        	String str[] = currentList.get(i).split("\\|");
		        Student student=stbuilder(str);
		        if(!map.containsKey(student.getId()) || (map.containsKey(student.getId()) && !map.get(student.getId()).equals(student))) {
						processedList.add(student);
					
				}
		    }
		    mappingStream2.close();
		    isComplete=true;
		 System.out.println("completed " + processedList.toString()+"\n"+map.toString() );
		 return processedList;
	}
	public Student stbuilder(String[] st) {
		Student student =new Student();
		student.setId(Integer.parseInt(st[0]));
		student.setName(st[1]);
		student.setMarks(Integer.parseInt(st[2]));
		student.setGrade(st[3]);
		student.setPercentage(Integer.parseInt(st[4]));
		return student;
	}

	
	//	public CsvReader() {
//		this.setResource(new ClassPathResource("previous.csv"));
//		this.setLinesToSkip(1);
//		DefaultLineMapper<Student> mapper=new DefaultLineMapper<>();
//   	 	DelimitedLineTokenizer tokenizer=new DelimitedLineTokenizer();
//   	 	tokenizer.setDelimiter("|");
//   	 	tokenizer.setNames(Student.fields());
//   	 	mapper.setLineTokenizer(tokenizer);
//   	 	BeanWrapperFieldSetMapper<Student> fieldmapper=new BeanWrapperFieldSetMapper<>();
//   	 	fieldmapper.setTargetType(Student.class);
//   	 	mapper.setFieldSetMapper(fieldmapper);
//   	 	this.setLineMapper(mapper);
//		}
	}
