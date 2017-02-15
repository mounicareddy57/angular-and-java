package org.mounica.api.repository;

import java.util.List;

import org.mounica.api.entity.Ratings;

public interface RatingsRepository {

	List<Ratings> findAll();

	List<Ratings> findRatingsByMovie(String moviesId);

	Ratings findRatingsMoviesByUser(String moviesId, String userId);

	Ratings findRatings(String rId);

	Ratings create(Ratings ratings);

	Ratings update(Ratings ratings);

	void delete(Ratings ratings);

}



