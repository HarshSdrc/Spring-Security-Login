package com.harsh.repository;

import java.util.List;

import com.harsh.domain.Roles;

public interface RoleRepository {

	List<Roles> findAll();

}
