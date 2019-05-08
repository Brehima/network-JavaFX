package tn.redhats.network.networkServer.services;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

import javafx.collections.ObservableList;
import tn.redhats.network.networkServer.entities.JobOffer;

@Remote
public interface JobOfferServiceRemote {
	public void AddJobOffer(JobOffer JobO);
	public JobOffer UpdateJobOffer(JobOffer JobO);
	public void Remove(int id);
	public JobOffer findJobOfferById(int id);
	public List<JobOffer> findAllJobOffer();
	public List<JobOffer> showjobs();
}
