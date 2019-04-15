package com.ace.demo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Table;

@Entity
@Table(name="t_roles")
public class Roles implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	private String name;
	
	private String ability;
	
	
	/**
	 * 这是oneToOne
	
	 * @Title: getUser
	
	 * @Description: TODO
	
	 * @return
	
	 * @return: User
	 */
//	@OneToOne(mappedBy="roles")
//	private User user;
	

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	
	/***
	 * 一对多
	 */
//	@OneToMany(mappedBy="roles")
//	private Set<User> users = new HashSet<>();
//	public Set<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set<User> users) {
//		this.users = users;
//	}

	/***
	 * 多堆多
	 */
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="t_roles_menus",joinColumns=@JoinColumn(name="role_id"),inverseJoinColumns=@JoinColumn(name="menu_id"))
	private Set<menu> menus = new HashSet<>();
	
	
	public Set<menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<menu> menus) {
		this.menus = menus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}
	
	
	
}
