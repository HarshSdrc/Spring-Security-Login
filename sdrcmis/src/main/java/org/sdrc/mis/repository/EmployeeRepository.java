/**
 * 
 */
package org.sdrc.mis.repository;

import org.sdrc.mis.domain.EmployeeDetails;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
public interface EmployeeRepository {

	EmployeeDetails findByEmployeeCode(String empCode);

}
