package tn.redhats.network.networkServer.services_impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.redhats.network.networkServer.services.InterviewsServiceLocal;
import tn.redhats.network.networkServer.services.InterviewsServiceRemote;

@Stateless
@LocalBean
public class InterviewsService implements InterviewsServiceLocal, InterviewsServiceRemote {

	@PersistenceContext (unitName="networkServer-ejb")
	EntityManager em;
	public InterviewsService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public long count_Interviews () 
	
	{
		Query query = em.createQuery("SELECT COUNT (i.id) from Interview i ");
		Object res =  query.getSingleResult();
		long x = ((Number) res).intValue();
		print ("****************",x) ; 
		return x;
	}
	
	private void print(String string, long x) {
		// TODO Auto-generated method stub
		
	}

}
