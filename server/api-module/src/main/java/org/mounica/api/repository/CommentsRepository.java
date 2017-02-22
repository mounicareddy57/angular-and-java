package org.mounica.api.repository;

import java.util.List;

import org.mounica.api.entity.Comments;

public interface CommentsRepository {

	public Comments create(Comments com);

	public List<Comments> findCommentsByMovie(String mid);

	public List<Comments> findCommentsByUser(String id);

	public void delete(Comments cId);

	public Comments findComment(String cId);
	

}
