package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
import java.sql.Timestamp;

import javax.persistence.*;





/**
 * Entity implementation class for Entity: Notification
 *
 */
@Entity

public class Notification implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	//private int idUserNotif;
	private Timestamp dateNotification;
	private String type;
	private String description;
	private boolean seen;
	
	@ManyToOne
	private User receiver;
	private static final long serialVersionUID = 1L;

	public Notification() {
		super();
	} 
	
	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Timestamp getDateNotification() {
		return this.dateNotification;
	}

	public void setDateNotification(Timestamp dateNotification) {
		this.dateNotification = dateNotification;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	
	
	
	
	

	@Override
	public String toString() {
		return "Notification [id=" + id + ", dateNotification=" + dateNotification + ", type=" + type + ", description="
				+ description + ", seen=" + seen + ", receiver=" + receiver + "]";
	}

	public Notification(Timestamp dateNotification, String type, String description,
			String image) {
		super();
		
		this.dateNotification = dateNotification;
		this.type = type;
		this.description = description;
		
		
	}
	
	
   
}
