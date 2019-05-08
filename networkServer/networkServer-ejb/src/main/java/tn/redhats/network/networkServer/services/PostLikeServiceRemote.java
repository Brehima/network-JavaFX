package tn.redhats.network.networkServer.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;

import tn.redhats.network.networkServer.entities.Comment;
import tn.redhats.network.networkServer.entities.Post;
import tn.redhats.network.networkServer.entities.PostLike;
import tn.redhats.network.networkServer.entities.User;


@Remote
@LocalBean
public interface PostLikeServiceRemote {
	int AddPostLike(PostLike pstlike);
	List<PostLike> findAllPostLike();
	List<Post> findPostLikeByOwner(User u);
    PostLike findLikeById (int id);
    public void RemovePost(int id);
}
