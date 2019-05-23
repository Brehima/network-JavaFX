package tn.redhats.network.networkServer.services;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import tn.redhats.network.networkServer.entities.EnterpriseProfile;
import tn.redhats.network.networkServer.entities.Event;
import tn.redhats.network.networkServer.entities.JobOffer;
import tn.redhats.network.networkServer.entities.Profile;
import tn.redhats.network.networkServer.entities.User;

@Remote
public interface EnterpriseServiceRemote {
	
	//CRUD EnterpriseProfile
	public void addEnterprise(EnterpriseProfile ep, User EnterpriseAdministrator, User HRManager, User ProjectManager, User RecruitementManager);
	public void showEnterpriseById(int id);
	public EnterpriseProfile findEnterpriseById(int id);
	public List<User> EnterpriseProfileUsers (int id);
	public List<EnterpriseProfile> findAllEnterprises();
	public void removeEnterprise(int id);
	public void removeEnterprise(EnterpriseProfile ep);
	public void updateEnterpriseProfile(int id, String introduction, String photo, String jobField, List<String> locations, String website, String employeesNumber, String enterpriseName);
	public String findLocations(int id);
	public Boolean checkEnterpriseName(String enterpriseName);
	public Boolean checkWebsite(String website);
	public Boolean checkEmail(String email);
	public Boolean checkUsername(String username);
	public User signInStepOne(String emailOrUsername);
	public void updateAccountStatusToDisabled(int id);
	public void updateAccountStatusToActivated(int id);
	public void updateLoginAttempts(int id, int number);
	public void addEvent(Event e);
	//public void removeEnterpriseEvents(int id);
	public List<Event> findEventsList(int id);
	public void addJobOffer(JobOffer jo);
	public List<JobOffer> findAllJobOffers();
}
