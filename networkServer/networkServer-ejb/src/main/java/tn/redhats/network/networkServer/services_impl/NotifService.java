package tn.redhats.network.networkServer.services_impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.management.Query;
import javax.naming.NoInitialContextException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.redhats.network.networkServer.entities.Notification;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.services.NotifServiceLocal;
import tn.redhats.network.networkServer.services.NotifServiceRemote;

@Stateless
@LocalBean
public class NotifService implements NotifServiceLocal {
	@PersistenceContext(unitName="networkServer-ejb")
	EntityManager em;
	
	@Override
	public void AddNotification(Notification notif) {
		// TODO Auto-generated method stub
		
		em.persist(notif);
			
	}
	
	@Override
	public void RemoveNotification(int id) {
		// TODO Auto-generated method stub
		Notification notif = em.find(Notification.class, id);
		if (notif != null)
		{
			em.remove(notif);
		}
	}
	
	/*@Override
	public void UpdateNotification(Notification notifNewValues) {
		// TODO Auto-generated method stub
		Notification notif = em.find(Notification.class, notifNewValues.getId());
		notif.(notifNewValues.isSeen());
	}*/
	
	
	@Override
	public List<Notification> findAllNotification() {
		// TODO Auto-generated method stub
		List<Notification> notif = em.createQuery("select n from Notification n", Notification.class).getResultList();
		return notif;
	}
	

	@Override
	public Notification findNotificationtById(int id) {
		// TODO Auto-generated method stub
		return em.find(Notification.class, id);
		
	}
	

	@Override
	public int getNumberOfNotSeenNotifications(User u) {
		
		 int notif =em.createQuery("select n from Notification n where n.user.id  = ?1 AND n.seen = 0",Notification.class).setParameter(1, u.getId()).getResultList().size();
		 return notif;
	}
	@Override
	public void setSeen(Notification notif) {
		notif.setSeen(true);
		em.merge(notif);
		
	}

	@Override
	public List<Notification> getNotificationsByUser(User u) {
		List<Notification> notifUser = em.createQuery("select n from Notification n where n.user.id  = ?1 ORDER BY n.date DESC",Notification.class).setParameter(1, u.getId()).setMaxResults(8).getResultList();
		return notifUser;
	}
}
