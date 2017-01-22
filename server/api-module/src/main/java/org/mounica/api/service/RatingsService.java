package org.mounica.api.service;

import java.util.List;

import org.mounica.api.entity.Ratings;

public interface RatingsService {


	public List<Ratings> findAll();

	public List<Ratings> findRatingsByMovie(String moviesId);

	public Ratings findRatingsMoviesByUser(String moviesId, String userId);

	public Ratings findRatings(String rId);

	public Ratings create(Ratings ratings);

	public Ratings update(Ratings ratings, String rId);

	public void delete(String rId);

	

}

