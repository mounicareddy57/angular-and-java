package org.mounica.api.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.mounica.api.entity.Ratings;
import org.mounica.api.repository.MoviesRepository;
import org.mounica.api.repository.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RatingsServiceImpl implements RatingsService {

	@Autowired
	private RatingsRepository rrepository;
	
	@Autowired
	MoviesRepository mrepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Ratings> findAll() {
		return rrepository.findAll();
	}

	@Override
	@Transactional
	public List<Ratings> findRatingsByMovie(String moviesId) {
		return rrepository.findRatingsByMovie(moviesId);
	}

	@Override
	@Transactional
	public Ratings findRatingsMoviesByUser(String moviesId, String userId) {
		return rrepository.findRatingsMoviesByUser(moviesId, userId);
	}

	@Override
	@Transactional
	public Ratings findRatings(String rId) {
		return rrepository.findRatings(rId);
	}

	@Override
	@Transactional
	public Ratings create(Ratings ratings) {
		return rrepository.create(ratings);
	}

	@Override
	@Transactional
	public Ratings update(Ratings ratings, String rId) {
		Ratings existing = rrepository.findRatings(rId);
		if(existing == null)
			throw new EntityNotFoundException("Rating with this id not found");
		else
		return rrepository.update(ratings);
	}

	@Override
	@Transactional
	public void delete(String rId) {
		Ratings existing = rrepository.findRatings(rId);
		if(existing == null)
			throw new EntityNotFoundException("Rating with this id not found");
		else
		 rrepository.delete(existing);
	}


}
