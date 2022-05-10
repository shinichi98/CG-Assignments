package com.assignments.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.assignments.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
