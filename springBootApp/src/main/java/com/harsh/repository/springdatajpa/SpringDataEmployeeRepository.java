package com.harsh.repository.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.harsh.domain.Employee;
import com.harsh.repository.EmployeeRepository;

public interface SpringDataEmployeeRepository extends EmployeeRepository,
		JpaRepository<Employee,Integer> {
	
	@Override
	@Query("Select emp from Employee emp where emp.employeeid=1")
	public Employee find();
}
