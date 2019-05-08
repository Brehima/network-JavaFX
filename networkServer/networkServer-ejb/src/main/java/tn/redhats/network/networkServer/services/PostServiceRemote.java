package tn.redhats.network.networkServer.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;

import tn.redhats.network.networkServer.entities.Post;
import tn.redhats.network.networkServer.entities.User;

@Remote
@LocalBean
public interface PostServiceRemote {
	int AddPost(Post p);
	void RemovePost (int id );
	void UpdatePost(Post p );
	Post findPosttById (int id);
	List<Post> findAllPost();
	List<Post>findPostByOwner(User u);
	//List<String> findAllPhotos(int id);
}
