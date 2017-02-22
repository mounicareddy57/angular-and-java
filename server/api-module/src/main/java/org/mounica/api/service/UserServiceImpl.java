package org.mounica.api.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.mounica.api.constants.AppConstants;
import org.mounica.api.datatransfer.Response;
import org.mounica.api.datatransfer.UserData;
import org.mounica.api.datatransfer.UserLogin;
import org.mounica.api.entity.User;
import org.mounica.api.exception.BadRequestException;
import org.mounica.api.mappings.UserMapping;
import org.mounica.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository urepository;
	
	@Autowired
	private UserMapping umapping;
	
	@Override
	@Transactional(readOnly=true)
	public List<UserData> findAll() {
		List<User> user = urepository.findAll();
		List<UserData> userData = user.stream().map(u -> umapping.getDataFromEntity(u)).collect(Collectors.toList());
		return userData;
	}

	@Override
	@Transactional
	public UserData findOne(String id) {
		User user = urepository.findOne(id);
		if(user == null){
			throw new EntityNotFoundException("User not found");
		}
		return umapping.getDataFromEntity(user);
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserData findByEmail(String email) {
		User user = urepository.findByEmail(email);
		if(user == null){
			throw new EntityNotFoundException("User with this email is not found");
		}
		return umapping.getDataFromEntity(user);
	}

	@Override
	@Transactional
	public UserData create(UserData userData) {
		User existing = urepository.findByEmail(userData.getEmail());
		if(existing != null){
			throw new BadRequestException("User with this email already exists");
		}
		userData.setRole(AppConstants.ROLE_USER);
		//Use ROLE_ADMIN to create admin credentials
		existing = umapping.getEntityFromData(userData, true);
		return umapping.getDataFromEntity(urepository.create(existing));
	}

	@Override
	@Transactional
	public UserData update(String id, UserData userData) {
		User existing = urepository.findOne(id);
		if(existing == null){
			throw new EntityNotFoundException("User not found");
		}
		existing = umapping.getEntityFromData(userData);
		return umapping.getDataFromEntity(urepository.update(existing));
	}

	@Override
	@Transactional
	public void delete(String id) {
		User existing = urepository.findOne(id);
		if(existing == null){
			throw new EntityNotFoundException("User not found");
		}
		urepository.delete(existing);
	}

	public Response authenticate(final UserLogin login) {
		if (login.email == null || urepository.findByEmail(login.email) == null 
								|| !urepository.findByEmail(login.email).getPassword().equals(login.password)){ 
			throw new EntityNotFoundException("Invalid username or password");
        }
		String role = urepository.findByEmail(login.email).getRole();
        return new Response(Jwts.builder().setSubject(login.email)
            .claim("roles", role).setIssuedAt(new Date())
            .signWith(SignatureAlgorithm.HS256, AppConstants.SECRET_KEY).compact(), role);
	}
}
