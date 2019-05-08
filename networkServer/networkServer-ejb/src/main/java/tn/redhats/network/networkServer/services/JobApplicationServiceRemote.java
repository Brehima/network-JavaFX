package tn.redhats.network.networkServer.services;

import java.util.List;

import javax.ejb.Remote;

import tn.redhats.network.networkServer.entities.JobApplication;
import tn.redhats.network.networkServer.entities.JobApplicationPK;
@Remote
public interface JobApplicationServiceRemote {
	Void updateJobApplication(int idJobOffer, int idUser);
	Void AddJobApplication(JobApplication JobA);
	JobApplicationPK findJobApplicationById (int idJobOffer,int idUser);
	List<JobApplication> findAllJobApplication();
}
