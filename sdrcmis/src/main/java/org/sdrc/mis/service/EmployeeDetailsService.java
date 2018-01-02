/**
 * 
 */
package org.sdrc.mis.service;

import org.sdrc.mis.model.EmployeeModel;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
public interface EmployeeDetailsService {

	
	public EmployeeModel findEmployeeByCode(String empCode);
}
