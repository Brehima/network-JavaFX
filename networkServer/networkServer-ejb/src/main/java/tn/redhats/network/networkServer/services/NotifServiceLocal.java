package tn.redhats.network.networkServer.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;

import tn.redhats.network.networkServer.entities.Notification;
import tn.redhats.network.networkServer.entities.User;

@Local
@LocalBean
public interface NotifServiceLocal {
	void AddNotification(Notification notif);
	void RemoveNotification (int id );
	//void UpdateNotification(Notification notif);
	
	List<Notification> findAllNotification();
	int getNumberOfNotSeenNotifications(User u);
	Notification findNotificationtById(int id);
	void  setSeen(Notification notif);
	List<Notification>getNotificationsByUser(User u);
	
}
