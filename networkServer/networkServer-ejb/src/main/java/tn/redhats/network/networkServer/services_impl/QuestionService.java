package tn.redhats.network.networkServer.services_impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.redhats.network.networkServer.entities.Question;
import tn.redhats.network.networkServer.entities.Answer;
import tn.redhats.network.networkServer.entities.JobOffer;
import tn.redhats.network.networkServer.services.AnswerServiceRemote;
import tn.redhats.network.networkServer.services.QuestionServiceLocal;
import tn.redhats.network.networkServer.services.QuestionServiceRemote;
import tn.redhats.network.networkServer.services.QuestionServiceLocal;
import tn.redhats.network.networkServer.services.QuestionServiceRemote;
@LocalBean
@Stateless
public class QuestionService implements QuestionServiceLocal, QuestionServiceRemote {

	@PersistenceContext(unitName="networkServer-ejb")
	EntityManager em;
	@Override
	public Question updateQuestion(Question quest) {
		Question ann = em.find(Question.class, quest.getId());
		    if (ann != null) {
		      ann.setQuestion(quest.getQuestion());
		     
		    }
		    return ann;
		
	
	}

	@Override
	public void AddQuestion(Question quest) {
		// TODO Auto-generated method stub
		em.merge(quest);
	}

	
	
	@Override
	public Question findQuestionById(int id) {
		// TODO Auto-generated method stub
		return em.find(Question.class, id);
	}

	@Override
	public List<Question> findAllQuestion() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT question FROM Question question ");
		return (List<Question>) query.getResultList();
	}
	
	public  void Remove(int id) {
		Question quest = findQuestionById(id);
	    
		
		if (quest != null) {
	      em.remove(quest);
	    }
	    
	}
	

}
