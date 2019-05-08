package tn.redhats.network.networkServer.services;

import java.util.List;

import javax.ejb.Local;

import tn.redhats.network.networkServer.entities.Answer;
import tn.redhats.network.networkServer.entities.JobApplication;
import tn.redhats.network.networkServer.entities.JobApplicationPK;

@Local
public interface AnswerServiceLocal {
	Answer updateAnswer(Answer ans);
	void AddAnswer(Answer ans);
	Answer findAnswerById (int id);
	List<Answer> findAllAnswer();
	public void Remove(int id);
}
