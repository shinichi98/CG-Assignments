package com.assign.CsvToDcsv.entity;

public class Student {
	private int id;
	private String name;
	private int marks;
	private String grade;
	private int percentage;
	private String rejectReason;
	
	public static String[] fields() {
		return new String[] {"id","name","marks","grade","percentage","rejectReason"};
	}
	public Student() {}
	public Student(int id, String name, int marks, String grade, int percentage) {
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.grade = grade;
		this.percentage = percentage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	 @Override 
	 public boolean equals(Object obj) {
	    if (this == obj) return true;
	    Student st = (Student)obj;
	    return  this.id==st.id
	    		&& this.name.equals(st.name)
	            && this.marks==st.marks
	            && this.grade.equals(grade)
	            && this.percentage == st.percentage;
	    }
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + ", grade=" + grade + ", percentage="
				+ percentage + "]";
	}
	public static String toStringw() {
		return "id|name|marks|grade|percentage";
	}
	public String getRejectReason() {
		return this.rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	
}
