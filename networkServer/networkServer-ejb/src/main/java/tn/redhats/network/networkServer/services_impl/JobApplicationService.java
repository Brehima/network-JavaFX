package tn.redhats.network.networkServer.services_impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.redhats.network.networkServer.entities.JobApplication;
import tn.redhats.network.networkServer.entities.JobApplicationPK;
import tn.redhats.network.networkServer.entities.JobOffer;
import tn.redhats.network.networkServer.services.JobApplicationServiceLocal;
import tn.redhats.network.networkServer.services.JobApplicationServiceRemote;

@Stateless
public class JobApplicationService implements JobApplicationServiceLocal, JobApplicationServiceRemote {
	@PersistenceContext(unitName="networkServer-ejb")
	EntityManager em;
	@Override
	
	public Void updateJobApplication(int idJobOffer,int idUser) {
		// TODO Auto-generated method stub
		
		TypedQuery<JobApplication> query = em.createQuery("select job from JobApplication job where job.jobOffer.id=:idJobOffer and job.user.id=:idUser ",JobApplication.class);
		query.setParameter("idJobOffer", idJobOffer)
			 .setParameter("idUser", idUser);
		try
		{
			JobApplication JobA = query.getSingleResult();
		    JobA.setStatus("deny");
		    em.merge(JobA);

		}
		catch (NoResultException e) {
			return null;// TODO: handle exception
		}
		
		return null;
       
	}
	
	@Override
	public Void AddJobApplication(JobApplication JobA) {
		// TODO Auto-generated method stub
		em.persist(JobA);
		return null;
	}
	@Override
	public List<JobApplication> findAllJobApplication() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public JobApplicationPK findJobApplicationById(int idJobOffer,int idUser) {
		// TODO Auto-generated method stub
		return em.find(JobApplicationPK.class, idJobOffer);
	}
}
