package tn.redhats.network.web.managedBean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Target;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import org.primefaces.event.FileUploadEvent;

import tn.redhats.network.networkServer.entities.Comment;
import tn.redhats.network.networkServer.entities.Post;
import tn.redhats.network.networkServer.entities.PostLike;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.services_impl.CommentService;
import tn.redhats.network.networkServer.services_impl.PostLikeService;
import tn.redhats.network.networkServer.services_impl.PostService;
import tn.redhats.network.networkServer.services_impl.UserService;

@ManagedBean
@SessionScoped
public class PostBean {
	// --------post entities------------
	private String description;
//private List<String> photos;
	private List<Post> posts;
	private String photos;
	private Part uploadedFile;
	private List<String> videos;
	private Timestamp datePost;
	private User postedBy;
	Post post;
	public int postIdToBeUpdated;
	private List<Comment> comments;
	private String folder = "C:/Users/Asus/Desktop/javaEE/Eclipse workspace/network-JavaFX/networkServer/networkServer-web/src/main/webapp/Medwise/wwsthemes.com/themes/medwise/v1.3/images";
	@EJB
	UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public int getPostIdToBeUpdated() {
		return postIdToBeUpdated;
	}

	public void setPostIdToBeUpdated(int postIdToBeUpdated) {
		this.postIdToBeUpdated = postIdToBeUpdated;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//-------Comment entities-----------
	private String text;
	private Timestamp dateComment;
	private User user;

	public User getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getVideos() {
		return videos;
	}

	public void setVideos(List<String> videos) {
		this.videos = videos;
	}

	public Timestamp getDatePost() {
		return datePost;
	}

	public void setDatePost(Timestamp datePost) {
		this.datePost = datePost;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getDateComment() {
		return dateComment;
	}

	public void setDateComment(Timestamp dateComment) {
		this.dateComment = dateComment;
	}

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	@EJB
	PostService postService;
	@EJB
	CommentService commentService;

	public void addPosts() throws ParseException, IOException {

		InputStream input = uploadedFile.getInputStream();
		String fileName = uploadedFile.getSubmittedFileName();
		System.out.println("uploadedFile.getSubmittedFileName : " + fileName);
		System.out.println("uploadedFile.getName() : " + uploadedFile.getName());

		String[] t = fileName.split("\\\\");

		Files.copy(input, new File(folder, t[t.length - 1]).toPath());

		System.out.println("test avant return");
		// postService.AddPost(new Post(description, datePost,, videos, likesNumber,
		// dislikesNumber));
		postService.AddPost(
				new Post(description, datePost, t[t.length - 1], comments, userService.signIn("test@test.tn")));

		/*
		 * String uuu = UUID.randomUUID().toString(); String fileName =
		 * uploadedFile.getSubmittedFileName(); Path from =
		 * Paths.get("C:/Users/Asus/Desktop"+ fileName); Path to = Paths.
		 * get("C:/Users/Asus/Desktop/javaEE/Eclipse workspace/network-JavaFX/networkServer/networkServer-web/src/main/webapp/Medwise/wwsthemes.com/themes/medwise/v1.3/images"
		 * + uuu + ".jpeg"); CopyOption[] options = new CopyOption[] {
		 * StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES };
		 * 
		 * try { Files.copy(from, to, options);
		 * 
		 * 
		 * } catch (IOException e) { e.printStackTrace(); } /*if(photos != null) {
		 * FacesMessage message = new FacesMessage("Succesful", uploadedFile.getName() +
		 * " is uploaded."); FacesContext.getCurrentInstance().addMessage(null,
		 * message); }
		 * 
		 * postService.AddPost(new Post(description, datePost, uuu+".jpeg", videos,
		 * likesNumber, dislikesNumber));
		 */
	}

	public void deletePost(int id) {

		postService.RemovePost(id);

	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public PostLikeService getPostlikeservice() {
		return postlikeservice;
	}

	public void setPostlikeservice(PostLikeService postlikeservice) {
		this.postlikeservice = postlikeservice;
	}

	public void displayPost(Post p) {
		this.setDescription(p.getDescription());
		this.setPhotos(p.getPhotos());
		this.setPostIdToBeUpdated(p.getId());
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		p.setDatePost(ts);

	}
	/*
	 * public String updatePost () { postService.UpdatePost(new
	 * Post(postIdToBeUpdated, description, datePost, photos));
	 * return("description"); }
	 */

	@PostConstruct
	public void init() {
		posts = postService.findAllPost();
	}

	public List<Post> findAllPosts() {
		posts = postService.findAllPost();

		return posts;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public void handleFileUpload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void addComments(Post id) 
	{

		commentService.AddComment(
				new Comment(text, dateComment, id, userService.signIn("test@test.tn")));
	}

	public String Details(int id) {
		post = postService.findPosttById(id);
		this.photos = post.getPhotos();
		this.description = post.getDescription();

		comments = commentService.findAllCommentbypost(id);
		// String navigateTo= "/Medwise/wwsthemes.com/themes/medwise/v1.3/blog-single";
		String navigateTo;
		return "blog-single?faces-redirect=true";

	}

	public List<Comment> comme() {

		return comments;

	}

//-----------postLike entities--------
	private User likedBy;

	public User getLikedBy() {
		return likedBy;
	}

	public void setLikedBy(User likedBy) {
		this.likedBy = likedBy;
	}

	@EJB
	PostLikeService postlikeservice;

	public void addLike(int id) throws ParseException {
		PostLike p = postlikeservice.findlike(postService.findPosttById(id), userService.signIn("test@test.tn"));
		if(p.getId() == 0) {
			postlikeservice.AddPostLike(new PostLike(postService.findPosttById(id), userService.signIn("test@test.tn")));	
		}
		

	}

	public boolean findlike(int id) throws ParseException {
		PostLike p = postlikeservice.findlike(postService.findPosttById(id), userService.signIn("test@test.tn"));
		if(p.getId() == 0) {
			return true;
		}
		return false;
	}

	public void delete(int id) {
		PostLike p = postlikeservice.findlike(postService.findPosttById(id), userService.signIn("test@test.tn"));
		if(p.getId() != 0) {
			postlikeservice.RemovePost(postlikeservice.findlike(postService.findPosttById(id), userService.signIn("test@test.tn")).getId());
		}
		
	}
}
