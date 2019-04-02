package tn.redhats.network.networkServer.services_impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.redhats.network.networkServer.services.UserServiceLocal;
import tn.redhats.network.networkServer.services.UserServiceRemote;

@LocalBean
@Stateless
public class UserService implements UserServiceLocal, UserServiceRemote {
	
	
	@PersistenceContext (unitName="networkServer-ejb")
	EntityManager em;
	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public long count_users () 
	
	{
		Query query = em.createQuery("SELECT COUNT (u.id) from User u ");
		Object res =  query.getSingleResult();
		long x = ((Number) res).intValue();
		print ("****************",x) ; 
		return x;
	}
	
	private void print(String string, long x) {
		// TODO Auto-generated method stub
		
	}

}
