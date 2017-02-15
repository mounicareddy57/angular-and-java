package org.mounica.api.controller;

import java.util.List;

import org.mounica.api.service.MoviesService;
import org.mounica.api.entity.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "movies")
public class MoviesController {
	
	@Autowired
	private MoviesService mservice;
	
	@RequestMapping(method= RequestMethod.GET)
	public List<Movies> findall()
	{
		return mservice.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Movies findByTitle(@PathVariable("id")String mtitle){
		return mservice.findOne(mtitle);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "title/{title}")
	public Movies findOneByTitle(@PathVariable("title")String mtitle){
		return mservice.findOneByTitle(mtitle);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "type/{type}")
	public Movies findOneByType(@PathVariable("type")String mtype){
		return mservice.findOneByType(mtype);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "year/{year}")
	public Movies findOneByYear(@PathVariable("year") int myear){
		return mservice.findOneByYear(myear);
	}
	
	@RequestMapping(method= RequestMethod.GET, value = "genre/{genre}")
	public Movies findOneByGenre(@PathVariable("genre") String mgenre){
		return mservice.findOneByGenre(mgenre);
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public Movies create(@RequestBody Movies mov){
		return mservice.create(mov);
		
	}
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Movies update(@PathVariable("id") String id, @RequestBody Movies mov)
	{
		return mservice.update(id, mov);
		
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id){
		mservice.delete(id);
		}

}

