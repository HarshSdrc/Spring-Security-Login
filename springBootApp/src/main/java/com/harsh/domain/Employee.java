package com.harsh.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {

	@Id
	@Column(name = "Eid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer employeeid;

	@Column(name = "firstName")
	String firstName;

	@Column(name = "lastName")
	String LastName;

	@Column(name = "password")
	String password;

	@Column(name = "emailID")
	String emailId;
	
	@Column(name="IsAlive")
	boolean isAlive;
	
	 @ManyToMany
	    @JoinTable(name = "emp_role", joinColumns = @JoinColumn(name = "emp_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Roles> roles;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

}
