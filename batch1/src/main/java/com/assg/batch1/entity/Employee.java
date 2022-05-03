package com.assg.batch1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
	
	@Id
	@Column(name = "EmpID")
	private int id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "CONTACT")
	private String contactNo;
	@Column(name = "DOJ")
	private String dob;
	@Column(name = "SALARY")
	private int salary;
	@Column(name = "DEPARTMENT_ID")
	private int dept;
	
}
