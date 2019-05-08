package tn.redhats.network.networkServer.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;

import tn.redhats.network.networkServer.entities.Post;
import tn.redhats.network.networkServer.entities.PostLike;
import tn.redhats.network.networkServer.entities.User;

@Local
@LocalBean
public interface PostLikeServiceLocal {
	int AddPostLike(PostLike pstlike);
	 PostLike findLikeById (int id);
	List<PostLike> findAllPostLike();
	List<Post> findPostLikeByOwner(User u);
}
