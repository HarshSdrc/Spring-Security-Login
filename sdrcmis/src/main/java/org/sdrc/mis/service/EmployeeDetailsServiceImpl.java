/**
 * 
 */
package org.sdrc.mis.service;

import org.sdrc.mis.domain.EmployeeDetails;
import org.sdrc.mis.model.EmployeeModel;
import org.sdrc.mis.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	/* (non-Javadoc)
	 * @see org.sdrc.mis.service.EmployeeDetailsService#findEmployeeByCode(java.lang.String)
	 */
	@Override
	public EmployeeModel findEmployeeByCode(String empCode) {
		
		EmployeeDetails employeeDetails = employeeRepository.findByEmployeeCode(empCode);
		EmployeeModel employeeModel = new EmployeeModel();
		if(employeeDetails !=null)
		{
			
		}
		return employeeModel;
	}

}
