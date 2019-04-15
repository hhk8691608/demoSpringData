package com.ace.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ace.demo.model.Roles;

/***
 * 

 * @ClassName: User

 * @Description: TODO

 * @author: admin

 * @date: 2019年4月15日 上午11:13:17
 */
@Entity
@Table(name="t_users_info")
public class User  implements Serializable{
	
	
		/**
	
	 * @fieldName: serialVersionUID
	
	 * @fieldType: long
	
	 * @Description: TODO
	
	 */
	private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    private String name;

	    private String email;
	    
	    @Transient
	    private Long roleId;
	    
	    
	    /***
	     * 作为one中的被维护端
	     * 指定one的另一方
	     */
	    @OneToOne(mappedBy="user")
	    UserInfo userInfo;
	    
	    /***
	     * 作为one中的被维护端
	     * 指定one的另一方
	     */
//	    @OneToOne(targetEntity=Roles.class,cascade=CascadeType.PERSIST)
//	    @JoinColumn(name="roleId",unique=true)
//	    Roles roles;
	    
	    
	    @ManyToOne(targetEntity=Roles.class,cascade=CascadeType.PERSIST)
	    @JoinColumn(name="role_id")
	    Roles roles;
	    

	    public Long getRoleId() {
			return roleId;
		}

		public void setRoleId(Long roleId) {
			this.roleId = roleId;
		}

		public Roles getRoles() {
			return roles;
		}

		public void setRoles(Roles roles) {
			this.roles = roles;
		}

		public UserInfo getUserInfo() {
			return userInfo;
		}

		public void setUserInfo(UserInfo userInfo) {
			this.userInfo = userInfo;
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

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

}
