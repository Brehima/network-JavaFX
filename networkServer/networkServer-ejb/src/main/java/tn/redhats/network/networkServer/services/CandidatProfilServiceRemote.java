package tn.redhats.network.networkServer.services;

import java.util.List;

import javax.ejb.Remote;

import tn.redhats.network.networkServer.entities.CandidateProfile;
import tn.redhats.network.networkServer.entities.Code2FACandidate;
import tn.redhats.network.networkServer.entities.EnterpriseProfile;
import tn.redhats.network.networkServer.entities.JobOffer;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.entities.invitations;

@Remote	
public interface CandidatProfilServiceRemote {
	Boolean signUp(User user);
	User signInStepOne(String id);
	Code2FACandidate signInStepTwo(int idUser);
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
	Boolean checkUserName(String name);
	Boolean checkEmail(String email);
	void addCode(Code2FACandidate code);
	void removeCode(int idUser);
	void updateCode(int idUser,String newCode);
	Code2FACandidate findCode(int idUser);
	User findUserByUsername(String username);
	User findUserByEmail(String email);
	void updateAccountStatus(User user);
	User updateUser(User user);
	User updateLogginAttempts(User user);
	void addEnterprise(User u,EnterpriseProfile enter);
	void sendFriendRequest(User sender,User receiver);
	List<invitations> getFriendRequest(User user);	
	void removeUserFriendList(int idSender,int idReceiver,String status);
}
