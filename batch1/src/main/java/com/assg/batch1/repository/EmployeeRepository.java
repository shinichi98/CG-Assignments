package com.assg.batch1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assg.batch1.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
