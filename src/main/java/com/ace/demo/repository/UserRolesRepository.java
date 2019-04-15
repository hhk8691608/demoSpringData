package com.ace.demo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ace.demo.model.User;

public interface UserRolesRepository extends CrudRepository<User, Long>{
	
	

	User getByEmail(String email);

	User getByIdAndName(Long id, String name);

	Iterable<User> findByIdBetween(Long id,Long id2);
	
	Iterable<User> findByIdAfter(Long id);
	
	Iterable<User> getByNameIsNull();
	
	Iterable<User> getByNameLike(String name);
	
	Iterable<User> getByNameContaining(String name);
	
	Iterable<User> findByIdIn(Collection<Long> ids);
	
	User getByUserInfoMobile(String mobile);
	
	@Query(value="FROM User WHERE id =?1 ")
	Iterable<User> simpleQueryById(Long id);
	
	@Query(value="FROM User WHERE id >=?1 ORDER BY id DESC")
	Iterable<User> simpleQueryByKId(Long id);
	
	@Query(value="FROM User WHERE name =?2 and id = ?1 ")
	User simpleQueryByVId(Long id,String name);
	
	@Query(value="FROM User WHERE  id in (select max(id) FROM User ) ")
	User simpleQueryBysVId();
	
	
	@Query(value="select * FROM User WHERE id >=?1 ORDER BY id DESC limit 5",nativeQuery=true)
	Iterable<User> simpleQueryByNative(Long id);
	
	@Modifying
	@Query(value="UPDATE User SET name =:name WHERE id=:id")
	int updateUserById(@Param("name") String name,@Param("id") Long id);
	
	
	
	
}
