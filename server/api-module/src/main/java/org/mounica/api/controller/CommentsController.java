package org.mounica.api.controller;

import java.util.List;

import org.mounica.api.entity.Comments;
import org.mounica.api.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="comments")
public class CommentsController {

	@Autowired
	private CommentsService cservice;
	
	@RequestMapping(method = RequestMethod.GET, path = "{id}")
	public Comments findComment(@PathVariable("id") String cId) {
		return cservice.findComment(cId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "movie/{moviesId}")
	public List<Comments> findCommentsByMovie(@PathVariable("moviesId") String moviesId) {
		return cservice.findCommentsByMovie(moviesId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "user/{userId}")
	public List<Comments> findCommentsByUser(@PathVariable("userId") String userId) {
		return cservice.findCommentsByUser(userId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Comments create(@RequestBody Comments com)   {
		return cservice.create(com);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String cId){
		cservice.delete(cId);
	}
}
