package tn.redhats.network.networkServer.services;

import java.util.List;

import javax.ejb.Local;

import tn.redhats.network.networkServer.entities.CandidateProfile;
import tn.redhats.network.networkServer.entities.JobOffer;
import tn.redhats.network.networkServer.entities.Post;
import tn.redhats.network.networkServer.entities.User;

@Local
public interface CandidatProfilServiceLocal {
	Boolean signUp(User user);
	void signInStepOne(String id, String password);
	void signInStepTwo(int code2FA);
	CandidateProfile showProfil(int id);
	CandidateProfile updateProfil(CandidateProfile profile);
	List<User> searchContact(String keyword);
	void addContact(int idCurrentUSER,int idUserToAdd);
	List<User> searchEntreprise(String keyword);
	Boolean subEnterprise(String keyword);
	List<User> showContact(int idUser);
	List<User> showFollowedEnterprise(int idEnterprise);
	List<JobOffer> showJobs(String keyword);
	CandidateProfile findCandidatById(int id);
	
}
