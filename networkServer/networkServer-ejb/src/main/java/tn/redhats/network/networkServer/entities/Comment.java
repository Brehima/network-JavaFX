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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String text;
	private Timestamp dateComment;
	@ManyToOne
	private Post post;
	  @ManyToOne
		private User comentedBy;
	private static final long serialVersionUID = 1L;

	public Comment() {
		super();
	}   
	public Comment(String champpub) {
		// TODO Auto-generated constructor stub
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
	
	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", text=" + text + ", dateComment=" + dateComment + ", post=" + post + "]";
	}
	public Comment(int id, String text, Timestamp dateComment, Post post) {
		super();
		this.id = id;
		this.text = text;
		this.dateComment = dateComment;
		
		this.post = post;
	}
	public Comment(String text, Timestamp dateComment, Post post) {
		super();
		this.text = text;
		this.dateComment = dateComment;
		this.post = post;
	}
	public Comment(String text, Timestamp dateComment, Post post, User comentedBy) {
		super();
		this.text = text;
		this.dateComment = dateComment;
		this.post = post;
		this.comentedBy = comentedBy;
	}
	public User getComentedBy() {
		return comentedBy;
	}
	public void setComentedBy(User comentedBy) {
		this.comentedBy = comentedBy;
	}
	
	
}
