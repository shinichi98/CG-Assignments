package com.assg.batch1.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.assg.batch1.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
