package com.ace.demo.invest.controller.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ace.demo.model.User;
import com.ace.demo.service.UserService;

@Controller
@RequestMapping(path = "/index")
@ResponseBody
public class IndexController {
	
	//eg : http://localhost:8080/demoSpringData/index/testAccess
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping(path = "/saveUser")
    public Map<String,Object> saveUser()
    {

		String mobile = "15625140888";
		String name = "jay";
		String email = "1562541@qq.com";
		
		Map<String,Object> result = new HashMap<>();
		User insertUser = new User();
		insertUser.setName(name);
		insertUser.setEmail(email);
		
		userService.saveUser(insertUser);
		
		result.put("code","200");
		result.put("msg","success");
		
		return result;
    }
	
	
	
	@GetMapping(path = "/testAccess")
    public Map<String,String> testAccess()
    {
		
		Map<String,String> result = new HashMap<String,String>();
		result.put("code","200");
		result.put("msg","success");
		return result;
    }
	
	
	
	@GetMapping(path = "/testRepository")
    public Map<String,Object> testRepository()
    {
		Map<String,Object> result = new HashMap<>();
		Iterable<User> users = userService.findAll();
		
		result.put("code","200");
		result.put("msg","success");
		result.put("users",users);
		return result;
    }
	
	
	@GetMapping(path = "/getByEmail")
    public Map<String,Object> getByEmail()
    {
		String email = "1562514@phoc.com";
		Map<String,Object> result = new HashMap<>();
		User users = userService.getByEmail(email);
		
		result.put("code","200");
		result.put("msg","success");
		result.put("users",users);
		return result;
    }
	
	
	@GetMapping(path = "/getByIdAndName")
    public Map<String,Object> getByIdAndName()
    {
		Map<String,Object> result = new HashMap<>();
		String name = "mark";
		Long id = 94L;
		User user = userService.getByIdAndName(id,name);
		
		result.put("code","200");
		result.put("msg","success");
		result.put("users",user);
		return result;
    }
	
	
	
	@GetMapping(path = "/findByIdAfter")
    public Map<String,Object> findByIdAfter()
    {
		Long id = 93L;
		Map<String,Object> result = new HashMap<>();
		Iterable<User> users = userService.findByIdAfter(id);
		
		result.put("code","200");
		result.put("msg","success");
		result.put("users",users);
		return result;
    }
	
	
	@GetMapping(path = "/getByNameIsNull")
    public Map<String,Object> getByNameIsNull()
    {
		Map<String,Object> result = new HashMap<>();
		Iterable<User> user = userService.getByNameIsNull();
		
		result.put("code","200");
		result.put("msg","success");
		result.put("users",user);
		return result;
    }
	
	
	
	@GetMapping(path = "/getByNameLike")
    public Map<String,Object> getByNameLike()
    {
		String name = "mark";
		Map<String,Object> result = new HashMap<>();
		Iterable<User> user = userService.getByNameLike(name);
		
		result.put("code","200");
		result.put("msg","success");
		result.put("users",user);
		return result;
    }
	
	
	@GetMapping(path = "/getByNameContaining")
    public Map<String,Object> getByNameContaining()
    {
		String name = "hhk";
		Map<String,Object> result = new HashMap<>();
		Iterable<User> user = userService.getByNameContaining(name);
		
		result.put("code","200");
		result.put("msg","success");
		result.put("users",user);
		return result;
    }
	

	@GetMapping(path = "/findByIdIn")
    public Map<String,Object> findByIdIn()
    {
		ArrayList<Long> ids = new ArrayList<>();
	
		ids.add(1L);
		ids.add(94L);
		
		Map<String,Object> result = new HashMap<>();
		Iterable<User> user = userService.findByIdIn(ids);
		
		result.put("code","200");
		result.put("msg","success");
		result.put("users",user);
		return result;
    }
	
	
	
	@GetMapping(path = "/getByUserInfoMobile")
    public Map<String,Object> getByUserInfoMobile()
    {

		String mobile = "15625140888";
		
		Map<String,Object> result = new HashMap<>();
		User user = userService.getByUserInfoMobile(mobile);
		
		result.put("code","200");
		result.put("msg","success");
		result.put("user.id",user.getId());
		result.put("user.name",user.getName());
		result.put("user.email",user.getEmail());
		
		result.put("info.id",user.getUserInfo().getId());
		result.put("info.mobile",user.getUserInfo().getMobile());
		result.put("info.address",user.getUserInfo().getAddress());
		result.put("info.uid",user.getUserInfo().getUid());
		
		return result;
    }
	
	
	
	@GetMapping(path = "/simpleQueryById")
    public Map<String,Object> simpleQueryById()
    {

		Long id = 25L;
		
		Map<String,Object> result = new HashMap<>();
		Iterable<User> user = userService.simpleQueryById(id);
		
		result.put("code","200");
		result.put("msg","success");
		result.put("user",user);
		
		return result;
    }
	
	
//	Iterable<User> simpleQueryByKId(Long id);
//	
//	User simpleQueryByVId(Long id,String name);
//	
//	User simpleQueryBysVId(Long id,String name);
	
	
	
	@GetMapping(path = "/simpleQueryByKId")
    public Map<String,Object> simpleQueryByKId()
    {

		Long id = 25L;
		
		Map<String,Object> result = new HashMap<>();
		Iterable<User> user = userService.simpleQueryByKId(id);
		
		result.put("code","200");
		result.put("msg","success");
		result.put("user",user);
		
		return result;
    }
	
	
	@GetMapping(path = "/simpleQueryByVId")
    public Map<String,Object> simpleQueryByVId()
    {

		Long id = 25L;
		String name = "mark";
		
		Map<String,Object> result = new HashMap<>();
		User user = userService.simpleQueryByVId(id,name);
		
		result.put("code","200");
		result.put("msg","success");
		result.put("user",user);
		
		return result;
    }
	
	
	
	
	@GetMapping(path = "/simpleQueryBysVId")
    public Map<String,Object> simpleQueryBysVId()
    {

		
		Map<String,Object> result = new HashMap<>();
		User user = userService.simpleQueryBysVId();
		
		result.put("code","200");
		result.put("msg","success");
		result.put("user",user);
		
		return result;
    }
	
	
	
	
	@GetMapping(path = "/simpleQueryByNative")
    public Map<String,Object> simpleQueryByNative()
    {

		Long id = 30L;
		Map<String,Object> result = new HashMap<>();
		Iterable<User> user = userService.simpleQueryByNative(id);
		
		result.put("code","200");
		result.put("msg","success");
		result.put("user",user);
		
		return result;
    }
	
	@GetMapping(path = "/updateUserById")
    public Map<String,Object> updateUserById()
    {

		Long id = 6L;
		String name = "kk";
		Map<String,Object> result = new HashMap<>();
		int suceessTotal = userService.updateUserById(name,id);
		
		result.put("code","200");
		result.put("msg","success");
		result.put("suceessTotal",suceessTotal);
		
		return result;
    }
	
	
	
	
	

}
