package tn.redhats.network.networkServer.services_impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public Boolean addContact(User user) {
		// TODO Auto-generated method stub
		return null;
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
}
