package org.mounica.api.service;

import java.util.List;

import org.mounica.api.datatransfer.Response;
import org.mounica.api.datatransfer.UserData;
import org.mounica.api.datatransfer.UserLogin;


public interface UserService {

	public List<UserData> findAll();
	public UserData findOne(String id);
	public UserData create(UserData userData);
	public UserData update(String id, UserData user);
	public UserData findByEmail(String email);
	public void delete(String id);
	public Response authenticate(final UserLogin login) ;
}
