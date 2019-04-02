package tn.redhats.network.networkServer.services_impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import tn.redhats.network.networkServer.services.JobofferServiceLocal;
import tn.redhats.network.networkServer.services.JobofferServiceRemote;

@Stateless
@LocalBean
public class JoboffersService implements JobofferServiceLocal, JobofferServiceRemote {

	@PersistenceContext (unitName="networkServer-ejb")
	EntityManager em;

	public JoboffersService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public long count_joboffers () 
	
	{
		Query query = em.createQuery("SELECT COUNT (j.id) from JobOffer j ");
		Object res =  query.getSingleResult();
		long x = ((Number) res).intValue();
		print ("****************",x) ; 
		return x;
	}
	
	private void print(String string, long x) {
		// TODO Auto-generated method stub
		
	}
}
