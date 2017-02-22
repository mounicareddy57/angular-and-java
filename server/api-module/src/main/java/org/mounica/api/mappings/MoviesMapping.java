package org.mounica.api.mappings;

import org.modelmapper.ModelMapper;
import org.mounica.api.datatransfer.MoviesData;
import org.mounica.api.entity.Movies;



public class MoviesMapping extends ModelMapper {
	public MoviesData getDtoFromEntity(Movies movie){
		return map(movie, MoviesData.class);
	}
	
	public Movies getEntityFromData(MoviesData moviesData){
		return map(moviesData, Movies.class);
	}
	
	public Movies getEntityFromDto(MoviesData moviesData, boolean isNew){
		Movies movie = getEntityFromData(moviesData);
		if(isNew){
			movie.setImdbId(new Movies().getImdbId());
			//movie.setActive(true);
		}
		return movie;
	}

}
