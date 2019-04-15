package com.ace.demo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ace.demo.model.Roles;
import com.ace.demo.model.User;

public interface RolesRepository extends CrudRepository<Roles, Long>{
	
	
	
}
