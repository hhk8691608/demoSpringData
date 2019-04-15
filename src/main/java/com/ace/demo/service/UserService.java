package com.ace.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.ace.demo.model.User;



public interface UserService {
	
		Iterable<User> findAll();
	
		void addUser(String name, String email);

	    Iterable<User> getAllUsers();

	    void doTransaction();

	    void testMultipleDS();

	    void testMultipleJDBC();
	    
	    User getByEmail(String email);
	    
	    User getByIdAndName(Long id,String name);
	    
	    
	    Iterable<User> findByIdAfter(Long id);
		
		Iterable<User> getByNameIsNull();
		
		Iterable<User> getByNameLike(String name);
		
		Iterable<User> getByNameContaining(String name);
		
		Iterable<User> findByIdIn(Collection<Long> ids);
		
		User getByUserInfoMobile(String mobile);
		
		void saveUser(User user);
		
		void updateUser(User user);
		
		Iterable<User> simpleQueryById(Long id);
		
		Iterable<User> simpleQueryByKId(Long id);
		
		User simpleQueryByVId(Long id,String name);
		
		User simpleQueryBysVId();
		
		Iterable<User> simpleQueryByNative(Long id);
		
		int updateUserById(@Param("name") String name,@Param("id") Long id);


		User findOneToOne(Long id);
		
		
}
