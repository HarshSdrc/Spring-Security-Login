package com.harsh.repository;

import java.util.List;

import javax.transaction.Transactional;




import com.harsh.domain.Employee;


public interface EmployeeRepository {
	
	@Transactional
	public Employee save(Employee employee);
	
	List<Employee> findAll();
	
	Employee find();
	
	Employee findByEmailIdAndIsAliveTrue(String emailid);

}
