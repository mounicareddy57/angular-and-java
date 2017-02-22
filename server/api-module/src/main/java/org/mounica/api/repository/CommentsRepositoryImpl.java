package org.mounica.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.mounica.api.entity.Comments;
import org.springframework.stereotype.Repository;

@Repository
public class CommentsRepositoryImpl implements CommentsRepository
{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Comments findComment(String cId) {
		return em.find(Comments.class, cId);
	}
	
	
	@Override
	public List<Comments> findCommentsByMovie(String moviesId) {
		TypedQuery<Comments> query = em.createNamedQuery("Comments.findCommentsByMovie", Comments.class);
		query.setParameter("pmovie", moviesId);
		return query.getResultList();
	}
	
	@Override
	public List<Comments> findCommentsByUser(String userId) {
		TypedQuery<Comments> query = em.createNamedQuery("Comments.findCommentsByUser", Comments.class);
		query.setParameter("puser", userId);
		return query.getResultList();
	}
	
	
	@Override
	public Comments create(Comments com) {
		em.persist(com);
		return com;
	}

	@Override
	public void delete(Comments cId) {
		em.remove(cId);
	}

	

}
