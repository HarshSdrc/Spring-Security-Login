package com.harsh.service;

import java.util.List;

import com.harsh.domain.Employee;
import com.harsh.model.EmployeeModel;

public interface EmployeeService {

	public List<Employee> saveEmployee(String firstName,String lastName,String email,String Password);

	public List<EmployeeModel> getAll();
	
	public org.springframework.security.core.userdetails.User loadByUserName(String userName);
}
