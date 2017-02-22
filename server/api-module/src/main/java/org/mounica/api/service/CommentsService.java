package org.mounica.api.service;

import java.util.List;

import org.mounica.api.entity.Comments;

public interface CommentsService {

	public Comments create(Comments com);

	public List<Comments> findCommentsByMovie(String mid);

	public List<Comments> findCommentsByUser(String id);

	public void delete(String cId);

	public  Comments findComment(String cId);
	

}
