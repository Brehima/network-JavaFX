package tn.redhats.network.networkServer.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;

import tn.redhats.network.networkServer.entities.Comment;
import tn.redhats.network.networkServer.entities.Post;

@Remote
@LocalBean
public interface CommentServiceRemote {
	void AddComment(Comment c);
	void RemoveComment (int id );
	void UpdateComment(int id );
    Comment findCommentById (int id);
	List<Comment> findAllComment();
	List<Comment> findCommentPost(Post p);
}
