package tn.redhats.network.web.managedBean;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;

import tn.redhats.network.networkServer.entities.Notification;
import tn.redhats.network.networkServer.entities.Post;
import tn.redhats.network.networkServer.services_impl.NotifService;
import tn.redhats.network.networkServer.services_impl.UserService;

@ManagedBean
@SessionScoped
public class NotificationBean {
	private int idUserNotif;
	private Timestamp dateNotification;
	private String type;
	private String description;
	private boolean seen;
	List<Notification> notifications;
	private int nbr;
	Post post;
	
	public int getNbr() {
		return nbr;
	}
	public void setNbr(int nbr) {
		this.nbr = nbr;
	}
	public int getIdUserNotif() {
		return idUserNotif;
	}
	public void setIdUserNotif(int idUserNotif) {
		this.idUserNotif = idUserNotif;
	}
	public Timestamp getDateNotification() {
		return dateNotification;
	}
	public void setDateNotification(Timestamp dateNotification) {
		this.dateNotification = dateNotification;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isSeen() {
		return seen;
	}
	public void setSeen(boolean seen) {
		this.seen = seen;
	}
	
	
	public NotifService getNotificationService() {
		return notificationService;
	}
	public void setNotificationService(NotifService notificationService) {
		this.notificationService = notificationService;
	}	
	
public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}

@EJB
NotifService notificationService;
@EJB
UserService userservice;


public void addNotif() {
	//notificationService.AddNotification(new Notification(idUserNotif, dateNotification, type, description, status, image));
	
}


public void deleteNotification(int id) {
	notificationService.RemoveNotification(id);
	
}
/*public List<Notification> getAllNotif() {
	 notifications =notificationService.findAllNotification(post.getPostedBy());
		
	 return notifications;	
}




public void getallNotifications() {

	System.out.println("this method is now called time ");
	notifications = notificationService.findAllNotification(atb.getUser());
	for (Notification n : notifications) {
		n.setSeen(!n.isSeen());
	}
	UpdateNotificationsNumber();
	System.out.println(nbr);
}

public String findAllNotifs(){
	allNitifs=notificationsLocal.getAllNotifications(atb.getUser());
	
	for (Notification n : allNitifs) {
		n.setSeen(!n.getSeen());
	}
	return "/pages/notifications?faces-redirect=true";
}
public void UpdateNotificationsNumber() {
	this.nbr = notificationsLocal.getNumberOfNotSeenNotifications(atb.getUser());

}

public String Seen(Notification n) {
	notificationsLocal.setSeen(n);
	getallNotifications();
	return "";
}
public String seenNot(Notification n){
	int nb=allNitifs.indexOf(n);
	notificationsLocal.setSeen(n);
	allNitifs.get(nb).setSeen(false);
	
	return "";
}
public String deleteNotif(Notification n){
	notificationsLocal.deleteNotif(n);
	allNitifs.remove(n);
	return "";
}
public String seeAll(){
	for(Notification n : allNitifs){
		notificationsLocal.setSeen(n);
		n.setSeen(false);
	}
	return "";
}
// Getters and setters
public List<Notification> getNotifications() {
	return notifications;
}

public void setNotifications(List<Notification> notifications) {
	this.notifications = notifications;
}*/
}

