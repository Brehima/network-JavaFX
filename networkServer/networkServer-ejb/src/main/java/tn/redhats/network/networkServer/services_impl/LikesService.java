package tn.redhats.network.networkServer.services_impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.redhats.network.networkServer.services.LikesServiceLocal;
import tn.redhats.network.networkServer.services.LikesServiceRemote;


@LocalBean
@Stateless
public class LikesService implements LikesServiceLocal,LikesServiceRemote{

	@PersistenceContext (unitName="networkServer-ejb")
	EntityManager em;
	public LikesService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public long count_Likes () 
	
	{
		Query query = em.createQuery("SELECT SUM(c.likesNumber) AS NUMBER FROM Comment c");
		Object res =  query.getSingleResult();
		long x = ((Number) res).intValue();
		print ("****************",x) ; 
		return x;
	}
	
	
	@Override
	public long daily_Likes () 
	
	{

		Query query = em.createQuery("SELECT SUM(c.likesNumber) AS NUMBER FROM Comment c WHERE c.dateComment >= CURRENT_DATE");
		Object res =  query.getSingleResult();
		long x = ((Number) res).intValue();
		print ("****************",x) ; 
		return x;
	}
	
	@Override
	public long daily_posts () 
	
	{

		Query query = em.createQuery("SELECT COUNT (p.id) AS NUMBER FROM Post p WHERE p.datePost >= CURRENT_DATE");
		Object res =  query.getSingleResult();
		long x = ((Number) res).intValue();
		print ("****************",x) ; 
		return x;
	}
	
	@Override
	public long daily_comments () 
	
	{

		Query query = em.createQuery("SELECT COUNT(c.id) AS NUMBER FROM Comment c WHERE c.dateComment >= CURRENT_DATE");
		Object res =  query.getSingleResult();
		long x = ((Number) res).intValue();
		print ("****************",x) ; 
		return x;
	}
	
	@Override
	public long ratings () 
	
	{

		Query query = em.createQuery("SELECT COUNT(c.id) AS NUMBER FROM CourseRating c");
		Object res =  query.getSingleResult();
		long x = ((Number) res).intValue();
		print ("****************",x) ; 
		return x;
	}
	

	
	
	private void print(String string, long x) {
		// TODO Auto-generated method stub
		
	}
}
