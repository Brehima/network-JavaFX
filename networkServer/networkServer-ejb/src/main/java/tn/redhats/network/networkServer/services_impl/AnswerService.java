package tn.redhats.network.networkServer.services_impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.redhats.network.networkServer.entities.Answer;
import tn.redhats.network.networkServer.entities.JobOffer;
import tn.redhats.network.networkServer.services.AnswerServiceLocal;
import tn.redhats.network.networkServer.services.AnswerServiceRemote;
@LocalBean
@Stateless
public class AnswerService implements AnswerServiceLocal, AnswerServiceRemote {

	@PersistenceContext(unitName="networkServer-ejb")
	EntityManager em;
	@Override
	public Answer updateAnswer(Answer ans) {
		Answer ann = em.find(Answer.class, ans.getId());
		    if (ann != null) {
		      ann.setAnswer(ans.getAnswer());
		     
		    }
		    return ann;
		
	
	}

	@Override
	public void AddAnswer(Answer ans) {
		// TODO Auto-generated method stub
		em.merge(ans);
	
	}

	@Override
	public Answer findAnswerById(int id) {
		// TODO Auto-generated method stub
		return em.find(Answer.class, id);
	}

	@Override
	public List<Answer> findAllAnswer() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT answer FROM Answer answer ");
		return (List<Answer>) query.getResultList();
	}
	
	public  void Remove(int id) {
		Answer ans = findAnswerById(id);
	    if (ans != null) {
	      em.remove(ans);
	    }
	}
	

}
