package tn.redhats.network.networkServer.services;

import java.util.List;

import javax.ejb.Remote;

import tn.redhats.network.networkServer.entities.Answer;
import tn.redhats.network.networkServer.entities.Interview;
import tn.redhats.network.networkServer.entities.JobApplication;
import tn.redhats.network.networkServer.entities.JobApplicationPK;
import tn.redhats.network.networkServer.entities.Question;
@Remote
public interface InterviewServiceRemote {
	Interview updateInterview(Interview inter);
	void AddInterview(Interview inter);
	Interview findInterviewById (int id);
	List<Interview> findAllInterview();
	public void Remove(int id);
}
