package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Comment
 *
 */
@Entity

public class Comment implements Serializable {

	   
	@Id
	private int id;
	private String text;
	private Timestamp dateComment;
	private int likesNumber;
	private int dislikesNumber;
	@ManyToOne
	private Post post;
	private static final long serialVersionUID = 1L;

	public Comment() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}   
	public Timestamp getDateComment() {
		return this.dateComment;
	}

	public void setDateComment(Timestamp dateComment) {
		this.dateComment = dateComment;
	}   
	public int getLikesNumber() {
		return this.likesNumber;
	}

	public void setLikesNumber(int likesNumber) {
		this.likesNumber = likesNumber;
	}   
	public int getDislikesNumber() {
		return this.dislikesNumber;
	}

	public void setDislikesNumber(int dislikesNumber) {
		this.dislikesNumber = dislikesNumber;
	}   
	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", text=" + text + ", dateComment=" + dateComment + ", likesNumber=" + likesNumber
				+ ", dislikesNumber=" + dislikesNumber + ", post=" + post + "]";
	}
	
	
   
}
