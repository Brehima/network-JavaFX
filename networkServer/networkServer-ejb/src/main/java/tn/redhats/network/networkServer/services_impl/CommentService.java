package tn.redhats.network.networkServer.services_impl;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.redhats.network.networkServer.entities.Comment;
import tn.redhats.network.networkServer.entities.Post;
import tn.redhats.network.networkServer.services.CommentServiceLocal;
import tn.redhats.network.networkServer.services.CommentServiceRemote;

@Stateless
@LocalBean
public class CommentService implements CommentServiceRemote{
	@PersistenceContext(unitName="networkServer-ejb")
	EntityManager em;
	@Override
	public void AddComment(Comment c) {
		// TODO Auto-generated method stub
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		c.setDateComment(ts);
		c.setText("nids");
		
		em.persist(c);
	}

	@Override
	public void RemoveComment(int id  ) {
		// TODO Auto-generated method stub
		Comment c = em.find(Comment .class, id);
		if (c != null)
		{
			em.remove(c);
		}
	}

	@Override
	public void UpdateComment(int id) {
		// TODO Auto-generated method stub
		Comment c  = em.find(Comment.class, id);
		c.setText("test2");
	}

	@Override
	public Comment findCommentById(int id) {
		// TODO Auto-generated method stub
		return em.find(Comment.class, id);	}

	@Override
	public List<Comment> findAllComment() {
		// TODO Auto-generated method stub
		List<Comment> c = em.createQuery("select c from Comment c", Comment.class).getResultList();
		return c;
	}
	
	
	
@Override
public List<Comment> findCommentPost(Post p) {
	// TODO Auto-generated method stub
	List<Comment> c = em.createQuery("SELECT c FROM COMMENT WHERE id", Comment.class).getResultList();
	return c;
}

public List<Comment> findAllCommentbypost(int idpost) {
	// TODO Auto-generated method stub
	Query query = em.createQuery("select c from Comment c where c.post.id=:id", Comment.class);
	query.setParameter("id", idpost);
	return query.getResultList();
}
	

}
