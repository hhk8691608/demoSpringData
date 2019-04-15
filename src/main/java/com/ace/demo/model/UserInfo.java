package com.ace.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GeneratorType;


/**
 * oneToone
 * 拥有uid故作为维护方
 * TO one 的一方作为被维护端
 * @OneToOne(mappedBy="users")
 * UserInfo userInfo;
 * 
 * 
 * 
 */
@Entity
@Table(name="user_info")
public class UserInfo  implements Serializable{
	
	/**
	
	 * @fieldName: serialVersionUID
	
	 * @fieldType: long
	
	 * @Description: TODO
	
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String mobile;
	
	private String address ;
	@Transient
	private Long uid;
	
	@OneToOne(targetEntity=User.class)
	@JoinColumn(name="uid",unique=true)
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
