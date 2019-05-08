package tn.redhats.network.networkServer.services_impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.services.UserServiceLocal;
import tn.redhats.network.networkServer.services.UserServiceRemote;

@Stateless
@LocalBean
public class UserService implements UserServiceLocal, UserServiceRemote{
	@PersistenceContext(unitName="networkServer-ejb")
	EntityManager em;
	@Override
	public User signIn(String id) {
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
	public void addUser(User user) {
		em.persist(user.getProfile());
		em.persist(user);
	}
	
}
