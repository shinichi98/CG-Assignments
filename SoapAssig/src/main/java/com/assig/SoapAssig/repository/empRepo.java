package com.assig.SoapAssig.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assig.soapassig.entity.Employee;

@Repository
public interface empRepo extends JpaRepository<Employee, Integer> {

	Employee findByEmployeeId(int empId);
}
