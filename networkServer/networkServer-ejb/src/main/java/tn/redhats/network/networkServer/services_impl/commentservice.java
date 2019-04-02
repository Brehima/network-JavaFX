package tn.redhats.network.networkServer.services_impl;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.redhats.network.networkServer.entities.Comment;
import tn.redhats.network.networkServer.services.commentserviceLocal;
import tn.redhats.network.networkServer.services.commentserviceRemote;

@LocalBean
@Stateless
public class commentservice implements commentserviceLocal, commentserviceRemote

{
	
	@PersistenceContext (unitName="networkServer-ejb")
	EntityManager em;
    public void commentsservice() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public long count_comments() {
		// TODO Auto-generated method stub
		System.out.println("==============================================================");
		Query query = em.createQuery("SELECT COUNT(c.id) FROM Comment c");
		
		 long x = (long)query.getSingleResult();
		System.out.println("======================================"+x);
		
		
		return x;
	}


}
