package org.mounica.api.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.mounica.api.entity.Movies;
import org.mounica.api.exception.BadRequestException;
import org.mounica.api.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MoviesServiceImpl implements MoviesService {
	
	@Autowired
	private MoviesRepository mrepository;

	@Override
	@Transactional(readOnly=true)
	public List<Movies> findAll() {
		return mrepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Movies findOne(String id) {
		Movies mov = mrepository.findOne(id);
		if(mov == null){
			throw new EntityNotFoundException("Movie not found");
		}
		return mov;
	}
	
	@Override
	@Transactional(readOnly=true)
	public Movies findOneByTitle(String title) {
		Movies mov = mrepository.findOneByTitle(title);
		if(mov == null){
			throw new EntityNotFoundException("Movie not found");
		}
		return mov;
	}
	
	@Override
	@Transactional(readOnly=true)
	public Movies findOneByType(String type) {
		Movies mov = mrepository.findOneByType(type);
		if(mov == null){
			throw new EntityNotFoundException("Movie not found");
		}
		return mov;
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Movies findOneByYear(int year) {
		Movies mov = mrepository.findOneByYear(year);
		if(mov == null){
			throw new EntityNotFoundException("Movie not found");
		}
		return mov;
	}

	@Override
	@Transactional(readOnly=true)
	public Movies findOneByGenre(String genre){
		Movies mov = mrepository.findOneByGenre(genre);
		if(mov == null){
			throw new EntityNotFoundException("Movie not found");
		}
		return mov;
	}
	
	@Override
	@Transactional
	public Movies create(Movies mov) {
		Movies existing = mrepository.findOne(mov.getTitle());
		if(existing != null){
			throw new BadRequestException("Movie with this title already exists");
		}
		return mrepository.create(mov);
	}

	@Override
	@Transactional
	public Movies update(String id, Movies mov) {
		Movies existing = mrepository.findOne(id);
		if(existing == null){
			throw new EntityNotFoundException("Movie not found");
		}
		return mrepository.update(mov);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Movies existing = mrepository.findOne(id);
		if(existing == null){
			throw new EntityNotFoundException("Movie not found");
		}
		mrepository.delete(existing);
	}

	

}
