package tn.redhats.network.web.managedBean;

import java.sql.Timestamp;

import java.text.ParseException;
import java.util.List;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.redhats.network.networkServer.entities.Comment;
import tn.redhats.network.networkServer.entities.Post;
import tn.redhats.network.networkServer.services_impl.CommentService;


@ManagedBean
@SessionScoped
public class CommentBean{
	
	private String text;
	private Timestamp dateComment;
	private Post post;
	List<Comment> comments;
	
	

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


	

	public CommentService getCommentservice() {
		return commentservice;
	}


	public void setCommentservice(CommentService commentservice) {
		this.commentservice = commentservice;
	}


	

	

	public Post getPost() {
		return post;
	}


	public void setPost(Post post) {
		this.post = post;
	}

	@EJB
	CommentService commentservice;

	public void addComments () throws ParseException{
	    	commentservice.AddComment(new Comment( text, dateComment, post));
	    }
	
	public List<Comment> findAllComments() {
		 comments =commentservice.findAllComment();
		
		 return comments;
		}
	
	public void deleteComment (int id) {
		commentservice.RemoveComment(id);
	}
	
	/*public int UpdateComment () {
		this.setUpdatedId(comment.getId());
		commentservice.UpdateComment(new Comment(UpdatedId,text, dateComment, likesNumber, dislikesNumber, post));
		
	}*/
	
	public void findComById(int id) {
		commentservice.findCommentById(id);
		
	}
}
