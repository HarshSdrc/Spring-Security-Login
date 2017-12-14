/**
 * 
 */
package com.harsh.repository.springdatajpa;

import org.springframework.data.repository.RepositoryDefinition;

import com.harsh.domain.Roles;
import com.harsh.repository.RoleRepository;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */

@RepositoryDefinition(domainClass=Roles.class,idClass=Integer.class)
public interface SpringDataRoleRepository extends RoleRepository {

}
