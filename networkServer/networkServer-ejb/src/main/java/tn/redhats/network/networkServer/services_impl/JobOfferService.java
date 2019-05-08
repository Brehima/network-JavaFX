package tn.redhats.network.networkServer.services_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;




import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.redhats.network.networkServer.entities.JobApplication;
import tn.redhats.network.networkServer.entities.JobOffer;
import tn.redhats.network.networkServer.services.JobOfferServiceLocal;
import tn.redhats.network.networkServer.services.JobOfferServiceRemote;
@LocalBean
@Stateless
public class JobOfferService implements JobOfferServiceLocal, JobOfferServiceRemote {
	@PersistenceContext(unitName="networkServer-ejb")
	EntityManager em;
	
	
    Statement statement;
    Connection connection;
    ResultSet result;
	
	
	@Override
	public void AddJobOffer(JobOffer JobO) {
		// TODO Auto-generated method stub
		em.merge(JobO);
	}
	@Override
	public List<JobOffer> findAllJobOffer() {
		Query query = em.createQuery("SELECT j FROM JobOffer j");
		return (List<JobOffer>) query.getResultList();
	}
	@Override
	public void Remove(int id) {
		JobOffer job = findJobOfferById(id);
		
	
		    if (job != null) {
		    	for (JobApplication j:job.getJobApplication())
				{
					em.remove(j);
				}
		      em.remove(job);
		    }
	}
	@Override
	public JobOffer UpdateJobOffer(JobOffer JobO) {
		
		 JobOffer job = em.find(JobOffer.class, JobO.getId());
		    if (job != null) {
		      job.setDescription(JobO.getDescription());
		      job.setExpertiseLevel(JobO.getExpertiseLevel());
		      job.setLocation(JobO.getLocation());
		    }
		    return job;
		
	}
	@Override
	public JobOffer findJobOfferById(int id) {
		return em.find(JobOffer.class, id);
	}
	@Override
	public List<JobOffer> showjobs() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	

	
}
