package tn.redhats.network.networkServer.services_impl;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	public CandidateProfile showProfil(int id) {
	
		return findCandidatById(id);
	}

	@Override
	public CandidateProfile updateProfil(CandidateProfile profile) {
		CandidateProfile cand = showProfil(profile.getId());
		cand = em.find(CandidateProfile.class,profile.getId());
		cand = profile;
	    
		//syncDatabase();
		return cand;
	}

	@Override
	public List<User> searchContact(String keyword) {
		Query query = em.createQuery("SELECT u from CandidateProfile u"+"where u.id like '%"+keyword+"%' "
																	   + "or u.firstName like '%"+keyword+"%'"
																	   + "or u.lastName like '%"+keyword+"%'"
																	   + "or u.username like '%"+keyword+"%'"
																	   + "or u.email like '%"+keyword+"%'");
		List<User> users =(List<User>) query.getResultList();
		return users;
	}
	

	@Override
	public void addContact(int idCurrentUSER,int idUserToAdd){
		CandidateProfile candidat = findCandidatById(idCurrentUSER);
		CandidateProfile friend =  findCandidatById(idUserToAdd);
		List<User> friendList = candidat.getUsers().get(0).getUsers();
		friendList.add(friend.getUsers().get(0));
		candidat.getUsers().get(0).setUsers(friendList);
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
	public List<User> showContact(int idUser) {
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

	@Override
	public void signInStepOne(String id, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void signInStepTwo(int code2fa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> showFollowedEnterprise(int idEnterprise) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
