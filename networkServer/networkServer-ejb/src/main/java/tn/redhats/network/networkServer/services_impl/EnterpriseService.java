package tn.redhats.network.networkServer.services_impl;




import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.Session;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.redhats.network.networkServer.entities.EnterpriseProfile;
import tn.redhats.network.networkServer.entities.Event;
import tn.redhats.network.networkServer.entities.JobOffer;
import tn.redhats.network.networkServer.entities.Profile;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.enumeration.AccountStatus;
import tn.redhats.network.networkServer.enumeration.Role;
import tn.redhats.network.networkServer.services.EnterpriseServiceLocal;
import tn.redhats.network.networkServer.services.EnterpriseServiceRemote;

@Stateless
@LocalBean
public class EnterpriseService implements EnterpriseServiceLocal, EnterpriseServiceRemote {
	
	@PersistenceContext(unitName="networkServer-ejb")
	EntityManager em;
	public static String locations;
	
	
	
	@Override
	public void addEnterprise(EnterpriseProfile enterpriseProfile, User EnterpriseAdministrator,User HRManager, User ProjectManager, User RecruitementManager) {
		
		// Ajout dans la base
		
		em.persist(EnterpriseAdministrator);
		em.persist(HRManager);
		em.persist(ProjectManager);
		em.persist(RecruitementManager);
		em.persist(enterpriseProfile);
		System.out.println("Sign Up successful");
		
	}



	@Override
	public void showEnterpriseById(int id) {
		
		EnterpriseProfile ep = em.find(EnterpriseProfile.class, id);
		if (ep!= null) {
			
			System.out.println("=====EnterpriseProfile=====");
			System.out.println(ep.getId());
			System.out.println(ep.getIntroduction());
			System.out.println(ep.getPhoto());
			System.out.println(ep.getJobField());
			System.out.println(ep.getWebsite());
			System.out.println(ep.getEmployeesNumber());
			System.out.println(ep.getLocations());
			System.out.println(ep.getUsers());
					
			
		}else {
			System.out.println("Profile not found !");
		}
		
	}


	
	@Override
	public EnterpriseProfile findEnterpriseById(int id) {
		EnterpriseProfile ep = em.find(EnterpriseProfile.class, id);
		if(ep != null) {
			return ep;
		}else {
			return null;
		}
	}


	@Override
	public List<User> EnterpriseProfileUsers(int id) {
		EnterpriseProfile ep = em.find(EnterpriseProfile.class, id);
		if (ep != null) {
			Query query = em.createQuery("select u from User u where u.profile.id="+ep.getId());
			List<User> users = query.getResultList();
			return users;
		}else {
			return null;
		}
		
	}



	@Override
	public List<EnterpriseProfile> findAllEnterprises() {
		
		Query query = em.createQuery("select ep from EnterpriseProfile ep");
		return (List<EnterpriseProfile>) query.getResultList();
		
	}



	@Override
	public void removeEnterprise(int id) {
		
		EnterpriseProfile ep = em.find(EnterpriseProfile.class, id);
		if (ep != null) {
			
			em.remove(ep);
			System.out.println("Remove successful");
		}else {
			System.out.println("Profile not found !");
		}
		
	}


	@Override
	public void removeEnterprise(EnterpriseProfile ep) {

		ep = em.find(EnterpriseProfile.class, ep.getId());
		if (ep != null) {
			
			for (Event e : findEventsList(ep.getId())) {
				em.remove(e);
			}
			
			em.remove(ep);
			System.out.println("Remove successful");
		}else {
			System.out.println("Profile not found !");
		}
		
	}



	@Override
	public void updateEnterpriseProfile(int id, String introduction, String photo, String jobField,
			List<String> locations, String website, String employeesNumber, String enterpriseName) {
		EnterpriseProfile ep = em.find(EnterpriseProfile.class, id);
		if(ep != null) {
			ep.setIntroduction(introduction);
			ep.setPhoto(photo);
			ep.setJobField(jobField);
			ep.setLocations(locations);
			ep.setWebsite(website);
			ep.setEmployeesNumber(employeesNumber);
			ep.setEnterpriseName(enterpriseName);
			em.flush();
		}else {
			System.out.println("Profile not found !");
		}
	}



	@Override
	public String findLocations(int id) {
		locations="";
		EnterpriseProfile ep = em.find(EnterpriseProfile.class, id);
		for (String location : ep.getLocations()) {
			locations+=location+", ";
		}
		
		return locations.substring(0, locations.length() - 2);
	}



	@Override
	public Boolean checkEnterpriseName(String enterpriseName) {
		Query query = em.createQuery("select ep from EnterpriseProfile ep where ep.enterpriseName="+"'"+enterpriseName+"'");	
		try {
			query.getSingleResult();
			return true;
		}
		catch (NoResultException e) {
			System.out.println("-");
		}
		 return false;
	}



	@Override
	public Boolean checkWebsite(String website) {
		Query query = em.createQuery("select ep from EnterpriseProfile ep where ep.website="+"'"+website+"'");	
		try {
			query.getSingleResult();
			return true;
		}
		catch (NoResultException e) {
			System.out.println("-");
		}
		 return false;
	}



	@Override
	public Boolean checkEmail(String email) {
		Query query = em.createQuery("select u from User u where u.email="+"'"+email+"'");	
		try {
			query.getSingleResult();
			return true;
		}
		catch (NoResultException e) {
			System.out.println("-");
		}
		 return false;
	}



	@Override
	public Boolean checkUsername(String username) {
		Query query = em.createQuery("select u from User u where u.username="+"'"+username+"'");	
		try {
			query.getSingleResult();
			return true;
		}
		catch (NoResultException e) {
			System.out.println("-");
		}
		 return false;
	}



	@Override
	public User signInStepOne(String emailOrUsername) {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u where u.username= :username or u.email= :email",User.class);
		query.setParameter("username", emailOrUsername)
			  .setParameter("email", emailOrUsername);
		try {
			User user = query.getSingleResult();
			return user;
		} catch (NoResultException e) {
			System.out.println("no result found");
		}
		
		return null;
	}



	@Override
	public void updateAccountStatusToDisabled(int id) {
		// TODO Auto-generated method stub
		User user = em.find(User.class, id);
		if(user != null) {
			user.setAccountStatus(AccountStatus.DISABLED);
			em.flush();
		}else {
			System.out.println("Erreur de mise à jour !");
		}
	}



	@Override
	public void updateAccountStatusToActivated(int id) {
		// TODO Auto-generated method stub
		User user = em.find(User.class, id);
		if(user != null) {
			user.setAccountStatus(AccountStatus.ACTIVATED);
			em.flush();
		}else {
			System.out.println("Erreur de mise à jour !");
		}
	}



	@Override
	public void updateLoginAttempts(int id, int number) {
		// TODO Auto-generated method stub
		User user = em.find(User.class, id);
		if(user != null) {
			user.setLoginAttempts(number);
			em.flush();
		}else {
			System.out.println("Erreur de mise à jour !");
		}
	}



	@Override
	public void addEvent(Event e) {
		// TODO Auto-generated method stub
		em.persist(e);
	}



	@Override
	public List<Event> findEventsList(int id) {
		EnterpriseProfile ep = em.find(EnterpriseProfile.class, id);
		if (ep != null) {
			Query query = em.createQuery("select e from Event e where e.enterprise.id="+id);
			List<Event> events = query.getResultList();
			return events;
		}else {
			return null;
		}
	}



	@Override
	public void addJobOffer(JobOffer jo) {

		em.persist(jo);
		
	}



	@Override
	public List<JobOffer> findAllJobOffers() {
		Query query = em.createQuery("select jo from JobOffer jo");
		return (List<JobOffer>) query.getResultList();
	}


	/*
	@Override
	public void removeEnterpriseEvents(int id) {
		
		EnterpriseProfile ep = em.find(EnterpriseProfile.class, id);
		if(ep != null) {
			
		}
		
		
				
	}
	*/


	


	
	
	



	
		

	

	
}
