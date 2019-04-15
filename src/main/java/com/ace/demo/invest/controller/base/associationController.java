package com.ace.demo.invest.controller.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ace.demo.model.Roles;
import com.ace.demo.model.User;
import com.ace.demo.model.menu;
import com.ace.demo.repository.RolesRepository;
import com.ace.demo.repository.UserRepository;
import com.ace.demo.service.UserService;

@Controller
@RequestMapping(path = "/association")
@ResponseBody
public class associationController {
	
	//eg : http://localhost:8080/demoSpringData/association/OneToOne
	
		@Autowired
		private UserService userService;
		
		@Autowired
		private RolesRepository rolesRepository;
		
		@GetMapping(path = "/test")
	    public Map<String,Object> test()
	    {

			
			Map<String,Object> result = new HashMap<>();
			
			result.put("code","200");
			result.put("msg","success");
			
			return result;
	    }

		@GetMapping(path = "/insertOneToOne")
	    public Map<String,Object> insertOneToOne()
	    {
			
			String rName = "管理员";
			String rAbility = "最高权限";
			
			Roles roles = new Roles();
			roles.setName(rName);
			roles.setAbility(rAbility);
			
			String uName = "李白";
			String uEmail = "libai@163.com";
			User user = new User();
			user.setName(uName);
			user.setEmail(uEmail);
			user.setRoles(roles);
			
			userService.saveUser(user);
			
			Map<String,Object> result = new HashMap<>();
			
			result.put("code","200");
			result.put("msg","success");
			
			return result;
	    }
		
		@GetMapping(path = "/insertManyToMany")
	    public Map<String,Object> insertManyToMany()
	    {
			
			String rName = "销售经理";
			String rAbility = "管理销售代表权限";
			
			
			Roles roles = new Roles();
			roles.setName(rName);
			roles.setAbility(rAbility);
			roles.setId(1L);
			
			String name = "xxx管理平台";
			menu menu1 = new menu();
			menu1.setName(name+"1");
			menu1.setId(1L);
			
			menu menu2 = new menu();
			menu2.setName(name+"2");
			menu2.setId(2L);
			
			roles.getMenus().add(menu1);
			roles.getMenus().add(menu2);
			
			menu1.getRoles().add(roles);
			menu2.getRoles().add(roles);
			
			rolesRepository.save(roles);
			
			Map<String,Object> result = new HashMap<>();
			
			result.put("code","200");
			result.put("msg","success");
			
			return result;
	    }
		
		
		@GetMapping(path = "/insertOneToMany")
	    public Map<String,Object> insertOneToMany()
	    {
			
			String rName = "运维员";
			String rAbility = "管理系统分配权限";
			
			Roles roles = new Roles();
			roles.setName(rName);
			roles.setAbility(rAbility);
			
			String uName = "杜甫";
			String uEmail = "dufu@163.com";
			User user = new User();
			user.setName(uName);
			user.setEmail(uEmail);
			user.setRoles(roles);
			
			User use1r = new User();
			use1r.setName("李渡");
			use1r.setEmail("lidu@1586.com");
			use1r.setRoles(roles);
			
//			roles.getUsers().add(user);
//			roles.getUsers().add(use1r);
			
			userService.saveUser(user);
			userService.saveUser(use1r);
			
			
			Map<String,Object> result = new HashMap<>();
			
			result.put("code","200");
			result.put("msg","success");
			
			return result;
	    }

		
		
		
		@GetMapping(path = "/OneToOne")
	    public Map<String,Object> OneToOne()
	    {

			Long id = 210L;
			User dbUser = userService.findOneToOne(id);
			Map<String,Object> result = new HashMap<>();
			result.put("code","200");
			result.put("msg","success");
			result.put("User",dbUser);
			
			return result;
	    }

}
