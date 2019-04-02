package tn.redhats.network.networkServer.services_impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.redhats.network.networkServer.services.PostServiceLocal;
import tn.redhats.network.networkServer.services.PostServiceRemote;

@Stateless
@LocalBean
public class PostService implements PostServiceLocal, PostServiceRemote{

	@PersistenceContext (unitName="networkServer-ejb")
	EntityManager em;
	public PostService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public long count_Posts () 
	
	{
		Query query = em.createQuery("SELECT COUNT (p.id) from Post p ");
		Object res =  query.getSingleResult();
		long x = ((Number) res).intValue();
		print ("****************",x) ; 
		return x;
	}
	
	private void print(String string, long x) {
		// TODO Auto-generated method stub
		
	}
	
}
