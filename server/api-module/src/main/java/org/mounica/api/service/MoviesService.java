package org.mounica.api.service;

import java.util.List;

import org.mounica.api.entity.Movies;

public interface MoviesService {
	
	public List<Movies> findAll();
	
	public Movies findOne(String id);
	
	public Movies create(Movies mov);
	
	public Movies update(String id, Movies mov);
	
	public void delete(String id);

    public Movies findOneByTitle(String title);

	public Movies findOneByType(String type);

	public Movies findOneByYear(int year);

	public Movies findOneByGenre(String genre);

	
}
