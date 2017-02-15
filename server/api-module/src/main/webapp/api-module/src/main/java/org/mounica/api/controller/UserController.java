package org.mounica.api.controller;

import java.util.List;
import org.mounica.api.entity.User;
import org.mounica.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	private UserService uservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll(){
		return uservice.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public User findOne(@PathVariable("id") String userId) {
		return uservice.findOne(userId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User user){
		return uservice.create(user);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public User update(@PathVariable("id") String id, @RequestBody User user){
		return uservice.update(id, user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "{id}")
	public void delete(@PathVariable("id") String id){
		uservice.delete(id);
	}
	

}
