package tn.redhats.network.networkServer.services_impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.redhats.network.networkServer.services.EntrepriseServiceLocal;
import tn.redhats.network.networkServer.services.EntrepriseServiceRemote;
@Stateless
@LocalBean
public class EntrepriseService implements EntrepriseServiceRemote,EntrepriseServiceLocal{

	@PersistenceContext (unitName="networkServer-ejb")
	EntityManager em;
	public EntrepriseService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public long count_Enterprises () 
	
	{
		Query query = em.createQuery("SELECT COUNT(EP.id) from EnterpriseRating EP ");
		Object res =  query.getSingleResult();
		long x = ((Number) res).intValue();
		print ("****************",x) ; 
		return x;
	}
	
	private void print(String string, long x) {
		// TODO Auto-generated method stub
		
	}

}
 