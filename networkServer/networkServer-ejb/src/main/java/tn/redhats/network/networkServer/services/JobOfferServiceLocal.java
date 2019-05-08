package tn.redhats.network.networkServer.services;

import java.util.List;

import javax.ejb.Local;

import tn.redhats.network.networkServer.entities.JobOffer;

@Local
public interface JobOfferServiceLocal {
	public void AddJobOffer(JobOffer JobO);
	public JobOffer UpdateJobOffer(JobOffer JobO);
	public void Remove(int id);
	public JobOffer findJobOfferById(int id);
	public List<JobOffer> findAllJobOffer();
}
