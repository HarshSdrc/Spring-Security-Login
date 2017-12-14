/**
 * 
 */
package com.harsh.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.harsh.domain.Employee;
import com.harsh.repository.EmployeeRepository;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */

@Component
public class UserValidator implements Validator{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public boolean supports(Class<?> aClass) {
		return Employee.class.equals(aClass);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
        Employee user = (Employee) arg0;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");
        if (user.getFirstName().length() < 6 || user.getFirstName().length() > 32) {
            errors.rejectValue("firstName", "Size.userForm.username","User Name Size");
        }
        if (employeeRepository.findByEmailIdAndIsAliveTrue(user.getEmailId()) != null) {
            errors.rejectValue("emailId", "Duplicate.userForm.emailId","Duplicate Email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password","Password Size");
        }

        
    }

		
	

}
