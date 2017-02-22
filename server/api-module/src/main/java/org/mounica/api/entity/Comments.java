package org.mounica.api.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Comments.findCommentsByMovie", query = "SELECT e FROM Comments e WHERE e.movies.mid = :pmovie"),
	@NamedQuery(name = "Comments.findCommentsByUser", query = "SELECT e FROM Comments e WHERE e.user.id = :puser")
})
public class Comments {

	@Id
	private String cId;
	
	@Column(columnDefinition= "text")
	private String comment;
	
	@ManyToOne
	private User user;	
	
	@OneToOne
	private Movies movies;
	
	public Comments(){
		this.cId=UUID.randomUUID().toString();
	}
	
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Movies getMovies() {
		return movies;
	}

	public void setMovies(Movies movies) {
		this.movies = movies;
	}
	
}
