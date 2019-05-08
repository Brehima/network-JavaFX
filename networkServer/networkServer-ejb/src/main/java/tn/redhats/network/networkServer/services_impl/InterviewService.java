package tn.redhats.network.networkServer.services_impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.redhats.network.networkServer.entities.Interview;
import tn.redhats.network.networkServer.entities.Answer;
import tn.redhats.network.networkServer.entities.JobOffer;
import tn.redhats.network.networkServer.services.AnswerServiceRemote;
import tn.redhats.network.networkServer.services.InterviewServiceLocal;
import tn.redhats.network.networkServer.services.InterviewServiceRemote;
import tn.redhats.network.networkServer.services.InterviewServiceLocal;
import tn.redhats.network.networkServer.services.InterviewServiceRemote;

@Stateless
public class InterviewService implements InterviewServiceLocal, InterviewServiceRemote {

	@PersistenceContext(unitName="networkServer-ejb")
	EntityManager em;
	@Override
	public Interview updateInterview(Interview quest) {
		Interview ann = em.find(Interview.class, quest.getId());
		    if (ann != null) {
		      ann.setStatus(quest.getStatus());
		     
		    }
		    return ann;
		
	
	}

	@Override
	public void AddInterview(Interview quest) {
		// TODO Auto-generated method stub
		em.merge(quest);
	
	}

	@Override
	public Interview findInterviewById(int id) {
		// TODO Auto-generated method stub
		return em.find(Interview.class, id);
	}

	@Override
	public List<Interview> findAllInterview() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT status FROM Interview status ");
		return (List<Interview>) query.getResultList();
	}
	
	public  void Remove(int id) {
		Interview quest = findInterviewById(id);
	    
		
		if (quest != null) {
	      em.remove(quest);
	    }
	    
	}
	

}
