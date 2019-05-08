package tn.redhats.network.networkServer.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import tn.redhats.network.networkServer.entities.Notification;
import tn.redhats.network.networkServer.entities.User;

@Remote
@LocalBean
public interface NotifServiceRemote {
	void AddNotification(Notification notif);
	void RemoveNotification (int id );
	//void UpdateNotification(Notification notif);
	Notification findNotificationtById (int id);
	List<Notification> findAllNotification();
	int getNumberOfNotSeenNotifications(User u);
	List<Notification>getNotificationsByUser(User u);
}
