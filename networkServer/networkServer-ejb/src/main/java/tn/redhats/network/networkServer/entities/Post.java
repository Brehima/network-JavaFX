package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Post
 *
 */
@Entity

public class Post implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String description;
	@Column
	@ElementCollection(targetClass=String.class,fetch=FetchType.EAGER)
	private List<String> photos;
	@Column
	@ElementCollection(targetClass=String.class,fetch=FetchType.EAGER)
	private List<String> videos;
	private Timestamp datePost;
	private int likesNumber;
	private int dislikesNumber;
	private static final long serialVersionUID = 1L;

	public Post() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public List<String> getPhotos() {
		return this.photos;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}   
	public List<String> getVideos() {
		return this.videos;
	}

	public void setVideos(List<String> videos) {
		this.videos = videos;
	}   
	public Timestamp getDatePost() {
		return this.datePost;
	}

	public void setDatePost(Timestamp datePost) {
		this.datePost = datePost;
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
	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + ", photos=" + photos + ", videos=" + videos
				+ ", datePost=" + datePost + ", likesNumber=" + likesNumber + ", dislikesNumber=" + dislikesNumber
				+ "]";
	}
	
	
   
}
