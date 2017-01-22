package org.mounica.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.mounica.api.entity.Ratings;
import org.springframework.stereotype.Repository;

@Repository
public class RatingsRepositoryImpl implements RatingsRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Ratings> findAll() {
		TypedQuery<Ratings> query = em.createNamedQuery("Ratings.findAll", Ratings.class);
		return query.getResultList();
	}

	@Override
	public List<Ratings> findRatingsByMovie(String moviesId) {
		TypedQuery<Ratings> query = em.createNamedQuery("Rating.findRatingsByMovie", Ratings.class);
		query.setParameter("pmovie", moviesId);
		return query.getResultList();	}

	@Override
	public Ratings findRatingsMoviesByUser(String moviesId, String userId) {
		TypedQuery<Ratings> query = em.createNamedQuery("Ratings.findRatingsMoviesByUser", Ratings.class);
		query.setParameter("pmovie", moviesId);
		query.setParameter("puser", userId);
		return query.getSingleResult();
	}

	@Override
	public Ratings findRatings(String rId) {
		return em.find(Ratings.class, rId);
		}

	@Override
	public Ratings create(Ratings ratings) {
		em.persist(ratings);
		return ratings;
	}

	@Override
	public Ratings update(Ratings ratings) {
		em.merge(ratings);
		return ratings;
	}

	@Override
	public void delete(Ratings ratings) {
		em.remove(ratings);
	}
	

}
