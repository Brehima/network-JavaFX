package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ConsultationHistory
 *
 */
@Entity

public class ConsultationHistory implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Timestamp dateConsultation;
	@ManyToOne
	private User visitorUser;
	private User visitedUser;
	private static final long serialVersionUID = 1L;

	public ConsultationHistory() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Timestamp getDateConsultation() {
		return this.dateConsultation;
	}

	public void setDateConsultation(Timestamp dateConsultation) {
		this.dateConsultation = dateConsultation;
	}   
	public User getVisitorUser() {
		return this.visitorUser;
	}

	public void setVisitorUser(User visitorUser) {
		this.visitorUser = visitorUser;
	}   
	public User getVisitedUser() {
		return this.visitedUser;
	}

	public void setVisitedUser(User visitedUser) {
		this.visitedUser = visitedUser;
	}
	@Override
	public String toString() {
		return "ConsultationHistory [id=" + id + ", dateConsultation=" + dateConsultation + ", visitorUser="
				+ visitorUser + ", visitedUser=" + visitedUser + "]";
	}
	
	
   
}
