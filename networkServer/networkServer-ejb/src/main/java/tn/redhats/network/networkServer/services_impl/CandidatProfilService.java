package tn.redhats.network.networkServer.services_impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.redhats.network.networkServer.entities.CandidateProfile;
import tn.redhats.network.networkServer.entities.JobOffer;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.services.CandidatProfilServiceLocal;
import tn.redhats.network.networkServer.services.CandidatProfilServiceRemote;

@Stateless
public class CandidatProfilService implements CandidatProfilServiceLocal,CandidatProfilServiceRemote {
	
	@PersistenceContext(unitName="networkServer-ejb")
	private EntityManager em;
	@Override
	public Boolean signUp(User user) {
		syncDatabase();
		em.persist(user.getProfile());
		em.persist(user);
		return true;
	}

	@Override
	public User showProfil(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateProfil(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> searchContact(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public void addContact(int idCurrentUSER,int idUserToAdd){
		CandidateProfile candidat = findCandidatById(idCurrentUSER);
		CandidateProfile friend =  findCandidatById(idUserToAdd);
		List<User> friendList = candidat.getUsers().get(0).getUsers();
		friendList.add(friend.getUsers().get(0));
		candidat.getUsers().get(0).setUsers(friendList);
		//candidat.getUser().setUsers(users);candidat.getUser().getUsers().add(friend.getUser());
	}

	@Override
	public List<User> searchEntreprise(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean subEnterprise(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> showContact() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> showFollowedEnterprise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobOffer> showJobs(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	public void  syncDatabase() {
		em.flush();
	}
	@Override
	public CandidateProfile findCandidatById(int id)
	{
		syncDatabase();
		CandidateProfile candidat = em.find(CandidateProfile.class, id);
		
		return candidat;
		
	}
}
