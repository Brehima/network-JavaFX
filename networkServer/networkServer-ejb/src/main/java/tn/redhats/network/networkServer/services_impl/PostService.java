package tn.redhats.network.networkServer.services_impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.redhats.network.networkServer.entities.Post;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.services.PostServiceLocal;
import tn.redhats.network.networkServer.services.PostServiceRemote;

@Stateless
@LocalBean
public class PostService implements PostServiceRemote{
	@PersistenceContext(unitName="networkServer-ejb")
	EntityManager em;

	@Override
	public int AddPost(Post p) {
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		p.setDatePost(ts);
		em.persist(p);
		return p.getId();
	}

	@Override
	public void RemovePost(int id) {
		em.remove(em.find(Post.class, id));
	}

	@Override
	public void UpdatePost(Post p) {
		// TODO Auto-generated method stub
		em.merge(p);
		
	}

	@Override
	public Post findPosttById(int id) {
		// TODO Auto-generated method stub
		return em.find(Post.class, id);
	}

	@Override
	public List<Post> findAllPost() {
		// TODO Auto-generated method stub
		List<Post> p = em.createQuery("select p from Post p", Post.class).getResultList();
		return p;
	}

	//@Override
	//public List<String> findAllPhotos(int id) {
		//Post p = em.find(Post.class, id);
		//if (p != null) {
		//Query query = em.createQuery(deleteQuery)
		//}
	//}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Post> findPostByOwner(User u) {
		List<Post> p = em.createQuery("select p from Post p where p.postedBy.id = "+ u.getId()).getResultList();
		return p;
	}
	
	
}
