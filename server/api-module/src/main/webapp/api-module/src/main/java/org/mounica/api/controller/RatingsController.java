package org.mounica.api.controller;

import java.util.List;

import org.mounica.api.entity.Ratings;
import org.mounica.api.service.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "ratings")
public class RatingsController {

	@Autowired
	private RatingsService rservice;
	
		@RequestMapping(method = RequestMethod.GET)
		public List<Ratings> findAll(){
		return rservice.findAll();
		}
		
		@RequestMapping(method = RequestMethod.GET, value = "{moviesId}")
		public List<Ratings> findRatingsByMovie(@PathVariable("moviesId") String moviesId) {
			return rservice.findRatingsByMovie(moviesId);
		}
		
		@RequestMapping(method = RequestMethod.GET, value = "ratings/{moviesId}/{userId}")
		public Ratings findRatingsForMovieByUser(@PathVariable("moviesId") String moviesId, @PathVariable("userId") String userId) 
		{
			return rservice.findRatingsMoviesByUser(moviesId, userId);
		}
		
		@RequestMapping(method = RequestMethod.GET, value = "{id}")
		public Ratings findRatings(@PathVariable("id") String rId) {
			return rservice.findRatings(rId);
		}
		
		@RequestMapping(method = RequestMethod.POST)
		public Ratings create(@RequestBody Ratings ratings) {
			return rservice.create(ratings);
		}
		
		@RequestMapping(method = RequestMethod.PUT, value = "{id}")
		public Ratings update(@PathVariable("id") String rId, @RequestBody Ratings ratings) 
		{
			return rservice.update(ratings, rId);
		}
		
		@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
		public void delete(@PathVariable("id") String rId) {
			rservice.delete(rId);
	}
	
}
