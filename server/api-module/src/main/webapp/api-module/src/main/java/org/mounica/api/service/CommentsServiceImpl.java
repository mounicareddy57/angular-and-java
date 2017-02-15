package org.mounica.api.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.mounica.api.entity.Comments;
import org.mounica.api.repository.CommentsRepository;
import org.mounica.api.repository.MoviesRepository;
import org.mounica.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentsServiceImpl implements CommentsService {

	@Autowired
	private CommentsRepository crepository;
	
	@Autowired
	 MoviesRepository mrepository;
	
	@Autowired
	 UserRepository urepository;
	
	@Override
	@Transactional
	public Comments create(Comments com) {
		/*Movies existing = mrepository.findOne(com.getMovies().getMid());
		if (existing == null) 
			throw new EntityNotFoundException("Movie with id not found");
		else*/
			return crepository.create(com);
	}
	
	
	@Override
	public Comments findComment(String cId) {
		Comments existing = crepository.findComment(cId);
		if(existing == null)
			throw new EntityNotFoundException("Comment this with id not found");
		else
			return existing;
	}

	@Override
	@Transactional
	public List<Comments> findCommentsByMovie(String moviesId) {
		return crepository.findCommentsByMovie(moviesId);
	}
	
	@Override
	@Transactional
	public List<Comments> findCommentsByUser(String id) {
		return crepository.findCommentsByUser(id);
	}

	@Override
	public void delete(String cId) {
		Comments existing = crepository.findComment(cId);
		if(existing == null)
			throw new EntityNotFoundException("Comment with this id not found");
		else
			crepository.delete(existing);
	}

}
