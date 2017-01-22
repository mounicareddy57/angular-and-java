package org.mounica.api.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Movies.findAll", query = "SELECT e FROM Movies e"),
	@NamedQuery(name = "Movies.findByTitle", query = "SELECT e FROM Movies e WHERE e.title=:mtitle"),
	@NamedQuery(name = "Movies.findOneByTitle", query = "SELECT e FROM Movies e WHERE e.title=:mtitle"),
	@NamedQuery(name = "Movies.findOneByType", query = "SELECT e FROM Movies e WHERE e.type=:mtype"),
	@NamedQuery(name = "Movies.findOneByYear", query = "SELECT e FROM Movies e WHERE e.year=:myear"),
	@NamedQuery(name = "Movies.findOneByGenre", query = "SELECT e FROM Movies e WHERE e.genre=:mgenre"),
})
public class Movies {
	
	@Id
	private String mid;
    @Column(unique = true)
    private String title;
    private int year;
    private String genre;
    private String director;
    private String language;
    private String country;
    private int metaScore;
    private int imdbRating;
    private int imdbVotes;
    private String type;
	
   @OneToOne
    private Ratings ratings;
   
   @OneToOne
    private Comments comments;
    
	public Movies(){
		this.mid= UUID.randomUUID().toString();
	}
	public String getId() {
		return mid;
	}
	public void setId(String id) {
		this.mid = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getMetaScore() {
		return metaScore;
	}
	public void setMetaScore(int metaScore) {
		this.metaScore = metaScore;
	}
	
	public float getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(int imdbRating) {
		this.imdbRating = imdbRating;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public long getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
