package com.harsh.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harsh.domain.Employee;
import com.harsh.domain.Roles;
import com.harsh.repository.EmployeeRepository;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
        Employee user = employeeRepository.findByEmailIdAndIsAliveTrue(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Roles role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(), grantedAuthorities);
	}

}
