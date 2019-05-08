package tn.redhats.network.networkServer.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;

import tn.redhats.network.networkServer.entities.Comment;
import tn.redhats.network.networkServer.entities.Post;

@Local
@LocalBean
public interface CommentServiceLocal {
	void AddComment(Comment c);
	void RemoveComment (int id );
	void UpdateComment(int id );
    Comment findCommentById (int id);
	List<Comment> findAllComment();
	List<Comment> findCommentPost();
	List<Comment> findCommentPost(Post p);
	
	
	
}
