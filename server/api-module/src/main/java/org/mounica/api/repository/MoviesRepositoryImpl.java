package org.mounica.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.mounica.api.entity.Movies;
import org.springframework.stereotype.Repository;

@Repository
public class MoviesRepositoryImpl implements MoviesRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Movies> findAll() {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findAll", Movies.class);
		return query.getResultList();	
	}

	@Override
	public Movies findOne(String id) {
		return em.find(Movies.class, id);
	}

	@Override
	public Movies findByTitle(String title) {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findByTitle", Movies.class);
		query.setParameter("mtitle", title);
		List<Movies> movies = query.getResultList();
		if (movies != null && movies.size() == 1) {
			return movies.get(0);
		} else {
			return null;
		}
	}
		
	@Override
		public Movies findOneByTitle(String title) {
			TypedQuery<Movies> query = em.createNamedQuery("Movies.findOneByTitle", Movies.class);
			query.setParameter("mtitle", title);
			List<Movies> movies = query.getResultList();
			if (movies != null && movies.size() == 1) {
				return movies.get(0);
			} else {
				return null;
			}
		
	}
	@Override
	public Movies findOneByType(String type) {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findOneByType", Movies.class);
		query.setParameter("mtype", type);
		List<Movies> movies = query.getResultList();
		if (movies != null && movies.size() == 1) {
			return movies.get(0);
		} else {
		return null;
	}
	}
	
	@Override
	public Movies findOneByYear(int year) {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findOneByYear", Movies.class);
		query.setParameter("myear", year);
		List<Movies> movies = query.getResultList();
		if (movies != null && movies.size() == 1) {
			return movies.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public Movies findOneByGenre(String genre) {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findOneByGenre", Movies.class);
		query.setParameter("mgenre", genre);
		List<Movies> movies = query.getResultList();
		if (movies != null && movies.size() == 1) {
			return movies.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public Movies create(Movies mov) {
		em.persist(mov);
		return mov;
	}

	@Override
	public Movies update(Movies mov) {
		return em.merge(mov);
	}

	@Override
	public void delete(Movies mov) {
		em.remove(mov);
	}
	

}
