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
@NamedQueries({
	@NamedQuery(name = "Comments.findCommentsByMovie", query = "SELECT e FROM Comments e WHERE e.movies.mid = :pmovie"),
	@NamedQuery(name = "Comments.findCommentsByUser", query = "SELECT e FROM Comments e WHERE e.user.id = :puser")
})
public class Comments {

	@Id
	private String cId;
	private String comment;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
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
}
