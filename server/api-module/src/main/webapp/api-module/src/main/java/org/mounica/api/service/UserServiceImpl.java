package org.mounica.api.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.mounica.api.entity.User;
import org.mounica.api.exception.BadRequestException;
import org.mounica.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository urepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		return urepository.findAll();
	}

	@Override
	@Transactional
	public User findOne(String id) {
		User user = urepository.findOne(id);
		if(user == null){
			throw new EntityNotFoundException("User not found");
		}
		return user;
	}
	
	
	@Override
	@Transactional
	public User create(User user) {
		User existing = urepository.findByEmail(user.getEmail());
		if(existing != null){
			throw new BadRequestException("User with this email already exists");
		}
		return urepository.create(user);
	}

	@Override
	@Transactional
	public User update(String id, User user) {
		User existing = urepository.findOne(id);
		if(existing == null){
			throw new EntityNotFoundException("User not found");
		}
		return urepository.update(user);
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

}
