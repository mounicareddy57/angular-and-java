package org.mounica.api.controller;

import java.util.List;

import org.mounica.api.datatransfer.Response;
import org.mounica.api.datatransfer.UserData;
import org.mounica.api.datatransfer.UserLogin;
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
	public List<UserData> findAll(){
		return uservice.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public UserData findOne(@PathVariable("id") String userId) {
		return uservice.findOne(userId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{email}")
	public UserData findByEmail(@PathVariable("email") String email) {
		return uservice.findByEmail(email);
	}

	
	@RequestMapping(method = RequestMethod.POST, value="create")
	public UserData create(@RequestBody UserData user){
		return uservice.create(user);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "login")
    public Response login(@RequestBody final UserLogin login) {
		return uservice.authenticate(login);
    }
	
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public UserData update(@PathVariable("id") String id, @RequestBody UserData user){
		return uservice.update(id, user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "{id}")
	public void delete(@PathVariable("id") String id){
		uservice.delete(id);
	}
	

}
