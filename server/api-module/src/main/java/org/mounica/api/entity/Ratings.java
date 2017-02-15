package org.mounica.api.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({@NamedQuery(name = "Ratings.findAll", query = "SELECT e FROM Ratings e"),
	@NamedQuery(name = "Ratings.findRatingsByMovie", query = "SELECT e FROM Ratings e WHERE e.movies.mid = :pmovie"),
	@NamedQuery(name = "Ratings.findRatingsMoviesByUser", query = "SELECT e FROM Ratings e WHERE e.movies.mid = :pmovie AND e.user.id = :puser")
})

public class Ratings {

	@Id
	private String rId;
	private String imdbId;
	private float imdbRating;
	private String imdbVotes;
		
	@ManyToOne
	private Movies movies;
	
	@ManyToOne
	private User user;
	
	public Ratings(){
		this.rId=UUID.randomUUID().toString();
	}
	
	public float getImdbRating() {
		return imdbRating;
	}

	public String getrId() {
		return rId;
	}

	public void setrId(String rId) {
		this.rId = rId;
	}

	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public String getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	
}
