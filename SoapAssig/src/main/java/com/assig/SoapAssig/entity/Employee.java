package com.assig.SoapAssig.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "empid")
	private long empId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "contact")
	private String contact;

	public Employee() {}
	
	public Employee(long empId, String name, String contact) {
		this.empId = empId;
		this.name = name;
		this.contact = contact;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
}
