package tn.redhats.network.networkServer.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;

import tn.redhats.network.networkServer.entities.Post;
import tn.redhats.network.networkServer.entities.User;

@Local
@LocalBean
public interface PostServiceLocal {
	int AddPost(Post p);
	void RemovePost (int id );
	void UpdatePost(Post p);
	Post findPosttById (int id);
	List<Post> findAllPost();
	List<Post>findPostByOwner(User u);
	//List<String> findAllPhotos(int id);
	}
