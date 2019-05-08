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
	private Timestamp datePost;
	@Column
	//@ElementCollection(targetClass=String.class, fetch=FetchType.EAGER)
	private String photos;
	@Column
	@ElementCollection(targetClass=String.class, fetch=FetchType.EAGER)
	private List<String> videos;
	@OneToMany(targetEntity=Comment.class,cascade=CascadeType.ALL)
	private List<Comment>comments;
    @ManyToOne
	private User postedBy;
    
    @OneToMany(targetEntity=PostLike.class,cascade=CascadeType.ALL)
	private List<PostLike> postLikes;
	private static final long serialVersionUID = 1L;
	

	public Post() {
		super();
		//photos = new ArrayList<String>();
		//videos = new ArrayList<String>();
	} 
	
	public Post(String description, Timestamp datePost, String photos, List<Comment> comments, User postedBy) {
		super();
		this.description = description;
		this.datePost = datePost;
		this.photos = photos;
		this.comments = comments;
		this.postedBy = postedBy;
	}

	public User getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
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
	
	

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
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
	
	
	

	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + ", datePost=" + datePost + ", photos=" + photos
				+ ", videos=" + videos + ", comments=" + comments + ", postedBy=" + postedBy + ", postLikes="
				+ postLikes + "]";
	}

	public List<String> getVideos() {
		return videos;
	}

	public List<PostLike> getPostLikes() {
		return postLikes;
	}

	public void setPostLikes(List<PostLike> postLikes) {
		this.postLikes = postLikes;
	}

	public Post(int id, String description, Timestamp datePost, String photos, List<String> videos,
			List<Comment> comments, User postedBy) {
		super();
		this.id = id;
		this.description = description;
		this.datePost = datePost;
		this.photos = photos;
		this.videos = videos;
		this.comments = comments;
		this.postedBy = postedBy;
	}
	
	

		
   
}
