/**
 * 
 */
package org.sdrc.mis.repository.springdata;

import org.sdrc.mis.domain.EmployeeDetails;
import org.sdrc.mis.repository.EmployeeRepository;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */

@RepositoryDefinition(domainClass=EmployeeDetails.class,idClass=Integer.class)
public interface SpringDataEmployeeRepository extends EmployeeRepository {

}
