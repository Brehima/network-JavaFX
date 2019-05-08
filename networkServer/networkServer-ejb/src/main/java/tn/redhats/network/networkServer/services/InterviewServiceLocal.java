package tn.redhats.network.networkServer.services;

import java.util.List;

import javax.ejb.Local;

import tn.redhats.network.networkServer.entities.Answer;
import tn.redhats.network.networkServer.entities.JobApplication;
import tn.redhats.network.networkServer.entities.JobApplicationPK;
import tn.redhats.network.networkServer.entities.Interview;

@Local
public interface InterviewServiceLocal {
	Interview updateInterview(Interview inter);
	void AddInterview(Interview inter);
	Interview findInterviewById (int id);
	List<Interview> findAllInterview();
	public void Remove(int id);
}
