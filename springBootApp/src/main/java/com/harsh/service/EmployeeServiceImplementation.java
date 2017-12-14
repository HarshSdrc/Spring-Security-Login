package com.harsh.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.harsh.domain.Employee;
import com.harsh.domain.Roles;
import com.harsh.model.EmployeeModel;
import com.harsh.repository.EmployeeRepository;
import com.harsh.repository.RoleRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	
	 @Autowired 
	 private EmployeeRepository employeeRepository;
	
	 @Autowired
	 private MessageDigestPasswordEncoder passwordEncoder;
	 
	 @Autowired
	 private RoleRepository  roleRepository;


	@Transactional
	@Override
	public List<Employee> saveEmployee(String firstName,String lastName,String email,String Password) {
	
       if(employeeRepository.findByEmailIdAndIsAliveTrue(email)==null)
       {
    	Employee emp=new Employee();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setPassword(passwordEncoder.encodePassword(Password, email));
		emp.setAlive(true);
		emp.setEmailId(email);
		emp.setRoles(new HashSet<>(roleRepository.findAll()));
		emp=employeeRepository.save(emp);
       }
		List<Employee> employes= employeeRepository.findAll();
		
		return employes;

	}


	@Override
	public List<EmployeeModel> getAll() {
		List<Employee> employes= employeeRepository.findAll();
		List<EmployeeModel> employeeModels = new ArrayList<EmployeeModel>();
		for(Employee employee : employes)
		{
			EmployeeModel employeeModel=new EmployeeModel();
			employeeModel.setAlive(employee.isAlive());
			employeeModel.setEmailId(employee.getEmailId());
			employeeModel.setFirstName(employee.getFirstName());
			employeeModel.setLastName(employee.getLastName());
			
			employeeModels.add(employeeModel);
		}
		return employeeModels;
	}


	@Override
	public org.springframework.security.core.userdetails.User loadByUserName(String userName) {
		Employee employee =employeeRepository.findByEmailIdAndIsAliveTrue(userName);
		
		Set<GrantedAuthority> authorities = new HashSet<>();
		
		  for (Roles role : employee.getRoles()){
			  authorities.add(new SimpleGrantedAuthority(role.getName()));
	        }
		  return new org.springframework.security.core.userdetails.User(employee.getEmailId(), employee.getPassword(), authorities);
	}

}
