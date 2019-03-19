package tn.redhats.network.networkServer.services;

import java.util.List;

import javax.ejb.Local;

import tn.redhats.network.networkServer.entities.JobOffer;
import tn.redhats.network.networkServer.entities.Post;
import tn.redhats.network.networkServer.entities.User;

@Local
public interface CandidatProfilServiceLocal {
	Boolean signUp(User user);
	User showProfil(User user);
	User updateProfil(User user);
	List<User> searchContact(String keyword);
	Boolean addContact(User user);
	List<User> searchEntreprise(String keyword);
	Boolean subEnterprise(String keyword);
	List<User> showContact();
	List<User> showFollowedEnterprise();
	List<JobOffer> showJobs(String keyword);
	
}
