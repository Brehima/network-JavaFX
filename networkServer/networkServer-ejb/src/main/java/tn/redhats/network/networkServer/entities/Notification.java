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
	private Timestamp dateNotification;
	private String type;
	private String description;
	private String status;
	private static final long serialVersionUID = 1L;

	public Notification() {
		super();
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
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Notification [id=" + id + ", dateNotification=" + dateNotification + ", type=" + type + ", description="
				+ description + ", status=" + status + "]";
	}
	
	
   
}
