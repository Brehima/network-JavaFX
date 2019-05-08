package tn.redhats.network.networkServer.entities;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PostLike implements Serializable{

	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
@ManyToOne
private Post post;
@ManyToOne
private User likedBy;

public PostLike() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public Post getPost() {
	return post;
}
public void setPost(Post post) {
	this.post = post;
}
public User getLikedBy() {
	return likedBy;
}
public void setLikedBy(User likedBy) {
	this.likedBy = likedBy;
}
@Override
public String toString() {
	return "PostLike [id=" + id + ", post=" + post + ", likedBy=" + likedBy + "]";
}
public PostLike(int id, Post post, User likedBy) {
	super();
	this.id = id;
	this.post = post;
	this.likedBy = likedBy;
}

public PostLike(Post post, User likedBy) {
	super();
	this.post = post;
	this.likedBy = likedBy;
}


}
