package tn.redhats.network.networkServer.services;

import java.util.List;

import javax.ejb.Local;

import tn.redhats.network.networkServer.entities.Answer;
import tn.redhats.network.networkServer.entities.JobApplication;
import tn.redhats.network.networkServer.entities.JobApplicationPK;
import tn.redhats.network.networkServer.entities.Question;

@Local
public interface QuestionServiceLocal {
	Question updateQuestion(Question quest);
	void AddQuestion(Question quest);
	Question findQuestionById (int id);
	List<Question> findAllQuestion();
	public void Remove(int id);
}
