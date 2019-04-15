package com.ace.demo.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ace.demo.model.User;
import com.ace.demo.repository.UserRepository;
import com.ace.demo.service.UserService;

@Component
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepository userRepository;
	  
	  

	@Override
	public void addUser(String name, String email) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		userRepository.save(user);
		
	}

	@Override
	public Iterable<User> getAllUsers() {
		return null;
	}

	@Override
	public void doTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testMultipleDS() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testMultipleJDBC() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<User> findAll() {
		Iterable<User> users = userRepository.findAll();
		return users;
	}

	@Override
	public User getByEmail(String email) {
		return userRepository.getByEmail(email);
	}

	@Override
	public User getByIdAndName(Long id, String name) {
		return userRepository.getByIdAndName(id,name);
	}

	@Override
	public Iterable<User> findByIdAfter(Long id) {
		return userRepository.findByIdAfter(id);
	}

	@Override
	public Iterable<User> getByNameIsNull() {
		return userRepository.getByNameIsNull();
	}

	@Override
	public Iterable<User> getByNameLike(String name) {
		return userRepository.getByNameLike(name);
	}

	@Override
	public Iterable<User> getByNameContaining(String name) {
		return userRepository.getByNameContaining(name);
	}

	@Override
	public Iterable<User> findByIdIn(Collection<Long> ids) {
		return userRepository.findByIdIn(ids);
	}

	@Override
	public User getByUserInfoMobile(String mobile) {
		return userRepository.getByUserInfoMobile(mobile);
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}


	@Override
	public void updateUser(User user) {
		
	}
	


	@Override
	public Iterable<User> simpleQueryById(Long id) {
		return userRepository.simpleQueryById(id);
	}

	@Override
	public Iterable<User> simpleQueryByKId(Long id) {
		return userRepository.simpleQueryByKId(id);
	}

	@Override
	public User simpleQueryByVId(Long id, String name) {
		return userRepository.simpleQueryByVId(id,name);
	}

	@Override
	public User simpleQueryBysVId() {
		return userRepository.simpleQueryBysVId();
	}

	@Override
	public Iterable<User> simpleQueryByNative(Long id) {
		return userRepository.simpleQueryByNative(id);
	}

	@Override
	@Transactional
	public int updateUserById(String name, Long id) {
		return userRepository.updateUserById(name,id);
	}


	@Override
	public User findOneToOne(Long id) {
//		return userRepository.findOneToOne(id);
		return null;
	}
	
	
	
	

}
