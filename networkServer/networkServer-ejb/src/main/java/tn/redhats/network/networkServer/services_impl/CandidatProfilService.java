package tn.redhats.network.networkServer.services_impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.sun.javafx.geom.AreaOp.NZWindOp;

import tn.redhats.network.networkServer.entities.CandidateProfile;
import tn.redhats.network.networkServer.entities.Code2FACandidate;
import tn.redhats.network.networkServer.entities.JobOffer;
import tn.redhats.network.networkServer.entities.Profile;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.entities.invitations;
import tn.redhats.network.networkServer.enumeration.AccountStatus;
import tn.redhats.network.networkServer.services.CandidatProfilServiceLocal;
import tn.redhats.network.networkServer.services.CandidatProfilServiceRemote;

@Stateless
@LocalBean
public class CandidatProfilService implements CandidatProfilServiceLocal,CandidatProfilServiceRemote {
	
	@PersistenceContext(unitName="networkServer-ejb")
	private EntityManager em;
	@Override
	public Boolean signUp(User user) {
		syncDatabase();
		User u = em.find(User.class, user.getId());
		if(u!=null)
		{
			u.setLastName(user.getLastName());
			u.setAccountStatus(user.getAccountStatus());
			
			u.setEmail(user.getEmail());
			u.setFirstName(user.getFirstName());
		
	
			u.setLoginAttempts(user.getLoginAttempts());
			
			u.setPassword(user.getPassword());
			u.getProfile().setIntroduction(user.getProfile().getIntroduction());
			u.getProfile().setPhoto(user.getProfile().getPhoto());
			((CandidateProfile)u.getProfile()).setDateNaissance(  ((CandidateProfile)user.getProfile()).getDateNaissance()  );
			u.setUsername(user.getUsername());
			em.flush();
			//updateUser(user);
		    return true;
		}
		else
		{

			em.persist(user.getProfile());
			em.persist(user);
			return true;
		}
		
		
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
		TypedQuery<CandidateProfile> query = em.createQuery("UPDATE c FROM CandidateProfile c set c.code=:newCode where c.idUser= :idUser",CandidateProfile.class);
		//syncDatabase();
		return cand;
	}
   
	@Override
	public List<User> searchContact(String keyword) {
		Query query = em.createQuery("SELECT u from User u "+"where u.firstName like '%"+keyword+"%'"
																	   + "or u.lastName like '%"+keyword+"%'"
																	   + "or u.username like '%"+keyword+"%'"
																	   + "or u.email like '%"+keyword+"%'");
		//TypedQuery<User> quer = em.createQuery("SELECT u FROM User u where u.username= :username",User.class);
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
	public User signInStepOne(String id) {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u where u.username= :username or u.email= :email",User.class);
		query.setParameter("username", id)
			  .setParameter("email", id);
		try {
			User user = query.getSingleResult();
			return user;
		} catch (NoResultException e) {
			System.out.println("no result found");
		}		
		return null;
		
	}

	@Override
	public Code2FACandidate signInStepTwo(int idUser) {
		Code2FACandidate code= findCode( idUser);
		return code;
	}

	@Override
	public List<User> showFollowedEnterprise(int idEnterprise) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean checkUserName(String name) {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u where u.username= :username",User.class);
		query.setParameter("username", name);
		try {
			query.getSingleResult();
			return true;
		} catch (NoResultException e) {
			System.out.println("no result found");
		}
		
		return false;
		
	}

	@Override
	public Boolean checkEmail(String email) {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u where u.email= :email",User.class);
		query.setParameter("email",email);
		try {
			query.getSingleResult();
			return true;
		} catch (NoResultException e) {
			System.out.println("no result found");
		}
		
		return false;
	}

	@Override
	public void addCode(Code2FACandidate code) {
		syncDatabase();
		em.persist(code);
		
	}

	@Override
	public void removeCode(int idUser) {
		syncDatabase();
		Code2FACandidate code = em.find(Code2FACandidate.class, idUser);
		if(code!=null)
		{
			em.remove(code);
		}
		
	}

	@Override
	public void updateCode(int idUser, String newCode) {
		
		syncDatabase();
		Code2FACandidate code = em.find(Code2FACandidate.class, idUser);
		if(code!=null)
		{
			TypedQuery<Code2FACandidate> query = em.createQuery("UPDATE c FROM Code2FACandidate c set c.code=:newCode where c.idUser= :idUser",Code2FACandidate.class);
			query.setParameter(":newCode",newCode);	
			query.setParameter(":idUser", idUser);
			query.executeUpdate();
		}
	}

	@Override
	public Code2FACandidate findCode(int idUser) {
		syncDatabase();
		Code2FACandidate code = em.find(Code2FACandidate.class, idUser);
		if(code!=null)
		{
			return code;
		}
		return null;
	}

	@Override
	public User findUserByUsername(String username) {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u where u.username= :username",User.class);
		query.setParameter("username", username);
		try {
			System.out.println("------------------------------------"+query.getResultList());
			User user = query.getSingleResult();
			return user;
		} catch (NoResultException e) {
			System.out.println("no result found");
		}
		
		return null;
	}

	@Override
	public User findUserByEmail(String email) {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u where u.email= :email",User.class);
		query.setParameter("email",email);
		try {
			User user = query.getSingleResult();
			return user;
		} catch (NoResultException e) {
			System.out.println("no result found");
		}
		
		return null;
	}

	@Override
	public void updateAccountStatus(User user) {
		Query query = em.createQuery("UPDATE User u set u.accountStatus=:status where u.id= :id");
		query.setParameter("status", user.getAccountStatus());
		query.setParameter("id", user.getId());
		query.executeUpdate();
	}
/*
 * private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	@ManyToOne

	private Profile profile; (setDateNaissance(time);
		candidate.setSexe(sexe.getSelectionModel().getSelectedItem());
		candidate.setPhoto(profileHashName);)))))
	private AccountStatus accountStatus; //status will be ACTIVATED or DISABLED

	
	private int loginAttempts;
 */
	@Override
	public User updateUser(User user) {
		
		User u = em.find(User.class, user.getId());
		if(u!=null)
		{
			u.setLastName(user.getLastName());
			u.setAccountStatus(user.getAccountStatus());
			//u.setCourses(user.getCourses());
			u.setEmail(user.getEmail());
			u.setFirstName(user.getFirstName());
			//u.setJobApplication(user.getJobApplication());
			u.setLastName(user.getLastName());
			u.setLoginAttempts(user.getLoginAttempts());
			//u.setMessages(user.getMessages());
			u.setPassword(user.getPassword());
			//u.setProfile(user.getProfile());
			u.setUsername(user.getUsername());			   
			   for(User i:user.getUsers())
			   {
				   if(!u.getUsers().contains(i))
				   {
					   u.getUsers().add(i);
				   }
			   }
			/*  if(((CandidateProfile)u.getProfile()).getEducation().size() > 0)
			 {
			   for(String ch: ((CandidateProfile)u.getProfile()).getEducation())
		       {
		    	  em.remove(ch);
		       }
			 }  */
			   System.out.println("-----------------avant---" +((CandidateProfile)u.getProfile()).getEducation() );
			   System.out.println("-----------------apres---" +((CandidateProfile)user.getProfile()).getEducation() );
		       for(String ch: ((CandidateProfile)user.getProfile()).getEducation())
		       {
		    	   if(! ((CandidateProfile)u.getProfile()).getEducation().contains(ch) )
					{
		    		   ((CandidateProfile)u.getProfile()).getEducation().add(ch);
					}
		       }
		  /* if(((CandidateProfile)u.getProfile()).getVolunteeringExperiences().size() > 0)
				 {
		       for(String ch: ((CandidateProfile)u.getProfile()).getVolunteeringExperiences())
		       {
		    	  em.remove(ch);
		       }
			  }*/
		       for(String ch: ((CandidateProfile)user.getProfile()).getVolunteeringExperiences())
		       {
		    	   if(! ((CandidateProfile)u.getProfile()).getVolunteeringExperiences().contains(ch) )
					{
		    		   ((CandidateProfile)u.getProfile()).getVolunteeringExperiences().add(ch);
					}
		       }
			em.flush();
			//updateUser(user);
		    return u;
		}
		return null;
	}
    //public U
	@Override
	public User updateLogginAttempts(User user) {
	
		return null;
	}

	@Override
	public void sendFriendRequest(User sender, User receiver) {
		// TODO Auto-generated method stub
		invitations invi = new invitations();
		invi.setSender(sender);
		invi.setReceiver(receiver);
		if(em.find(invitations.class, invi.getId())==null)
		{
			em.persist(invi);
		}
	}

	@Override
	public List<invitations> getFriendRequest(User user) {
		TypedQuery<invitations> query = em.createQuery("SELECT inv FROM  invitations inv where inv.receiver.id= :userId",invitations.class);
		query.setParameter("userId", user.getId());
		try {
			//System.out.println("------------------------------------"+query.getResultList());
			List<invitations> invitation = query.getResultList();
			return invitation;
		} catch (NoResultException e) {
			System.out.println("no result found");
		}
		
		return null;
	}
	
	@Override
	public void removeUserFriendList(int idSender,int idReceiver,String status) {
		TypedQuery<invitations> query = em.createQuery("SELECT inv FROM  invitations inv where inv.receiver.id= :userId",invitations.class);
	//	TypedQuery<invitations> query = em.createQuery("DELETE inv FROM invitations inv where inv.receiver.id= :receiverId and inv.sender.id= :senderId",invitations.class);
		query.setParameter("userId", idReceiver);
		try {
			//System.out.println("------------------------------------"+query.getResultList());
			List<invitations> invitation = query.getResultList();
			for(invitations i: invitation)
			{
				if(i.getSender().getId()==idSender  && i.getReceiver().getId()==idReceiver)
				{
					if(status.equals("ACCEPT"))
					{
						//adding both contact in each users contact list
						User user = i.getReceiver();
						user.getUsers().add(i.getSender());
						User user2 = i.getSender();
						user2.getUsers().add(i.getReceiver());
						if(updateUser(user)!=null && updateUser(user2)!=null)
						{
							em.remove(i);
						}
					}
					else
					{
						em.remove(i);
					}
				}
			}
		} catch (NoResultException e) {
			System.out.println("no result found");
		}
		
    
	}

	
	
}
