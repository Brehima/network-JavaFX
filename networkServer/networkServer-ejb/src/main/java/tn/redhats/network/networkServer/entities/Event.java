package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity

public class Event implements Serializable {

	   
	@Id
	private int id;
	private String title;
	private String description;
	private Timestamp dateEvent;
	private String location;
	@ManyToOne
	private EnterpriseProfile enterprise;
	private static final long serialVersionUID = 1L;

	public Event() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Timestamp getDateEvent() {
		return this.dateEvent;
	}

	public void setDateEvent(Timestamp dateEvent) {
		this.dateEvent = dateEvent;
	}   
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}   
	public EnterpriseProfile getEnterprise() {
		return this.enterprise;
	}

	public void setEnterprise(EnterpriseProfile enterprise) {
		this.enterprise = enterprise;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", description=" + description + ", dateEvent=" + dateEvent
				+ ", location=" + location + ", enterprise=" + enterprise + "]";
	}
	
	
   
}
