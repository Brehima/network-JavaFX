package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TechnicalReclamation
 *
 */
@Entity

public class TechnicalReclamation implements Serializable {

	   
	@Id
	private int id;
	private String subject;
	private String description;
	private String status;
	@ManyToOne
	private User user;
	private static final long serialVersionUID = 1L;

	public TechnicalReclamation() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "TechnicalReclamation [id=" + id + ", subject=" + subject + ", description=" + description + ", status="
				+ status + ", user=" + user + "]";
	}
	
	
   
}
