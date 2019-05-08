package tn.redhats.network.networkServer.services;

import java.util.List;

import javax.ejb.Local;

import tn.redhats.network.networkServer.entities.JobApplication;
import tn.redhats.network.networkServer.entities.JobApplicationPK;

@Local
public interface JobApplicationServiceLocal {
	Void updateJobApplication(int idJobOffer, int idUser);
	Void AddJobApplication(JobApplication JobA);
	JobApplicationPK findJobApplicationById (int idJobOffer,int idUser);
	List<JobApplication> findAllJobApplication();
}
