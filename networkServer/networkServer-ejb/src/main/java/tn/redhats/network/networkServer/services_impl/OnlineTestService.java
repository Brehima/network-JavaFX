package tn.redhats.network.networkServer.services_impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.redhats.network.networkServer.entities.OnlineTest;
import tn.redhats.network.networkServer.entities.Question;
import tn.redhats.network.networkServer.entities.Answer;
import tn.redhats.network.networkServer.entities.JobOffer;
import tn.redhats.network.networkServer.services.AnswerServiceRemote;
import tn.redhats.network.networkServer.services.OnlineTestServiceLocal;
import tn.redhats.network.networkServer.services.OnlineTestServiceRemote;
import tn.redhats.network.networkServer.services.OnlineTestServiceLocal;
import tn.redhats.network.networkServer.services.OnlineTestServiceRemote;

@Stateless
@LocalBean
public class OnlineTestService implements OnlineTestServiceRemote {

	@PersistenceContext(unitName="networkServer-ejb")
	EntityManager em;
	@Override
	public OnlineTest updateOnlineTest(OnlineTest quest) {
		OnlineTest ann = em.find(OnlineTest.class, quest.getId());
		    if (ann != null) {
		      ann.setScore(quest.getScore());

		      ann.setTestType(quest.getTestType());
		     
		    }
		    return ann;
		
	}

	@Override
	public void AddOnlineTest(OnlineTest quest) {
		// TODO Auto-generated method stub
		em.merge(quest);
	
	}

	@Override
	public OnlineTest findOnlineTestById(int id) {
		// TODO Auto-generated method stub
		return em.find(OnlineTest.class, id);
	}

	@Override
	public List<OnlineTest> findAllOnlineTest() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT x FROM OnlineTest x");
		return (List<OnlineTest>) query.getResultList();
	}
	
	public  void Remove(int id) {
		OnlineTest quest = findOnlineTestById(id);
	    
		
		if (quest != null) {
	      em.remove(quest);
	    }
	    
	}

	@Override
	public List<Answer> getAnswersFromTest(int testId) {
		List<Answer>answers = new ArrayList<Answer>();
		for (Question q : getQuestionFromTest(testId)) {
			answers.add(q.getAnswer());
		}
		return answers;
	}

	@Override
	public List<Question> getQuestionFromTest(int testid) {
		return em.find(OnlineTest.class, testid).getQuestions();
	}
	

}
