package org.mounica.api.repository;

import java.util.List;

import org.mounica.api.entity.Movies;

public interface MoviesRepository {
	
	public List<Movies> findAll();
	
	public Movies findOne(String id);
	
	/*public Movies findByTitle(String title);*/
	
	public Movies create(Movies mov);
	
	public Movies update(Movies mov);
	
	public void delete(Movies mov);

	public Movies findOneByTitle(String title);

	public Movies findOneByType(String type);

	public Movies findOneByYear(int year);

	public Movies findOneByGenre(String genre);

	Movies findById(String mId);

}
