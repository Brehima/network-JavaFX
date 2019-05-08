package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: JobApplication
 *
 */
@Entity

public class JobApplication implements Serializable {

	   
	
	private String status;
	@EmbeddedId
	private JobApplicationPK jobApplicationPK;
	@ManyToOne
	@JoinColumn(name="idJobOffer", referencedColumnName="id", insertable=false, updatable=false)
	private JobOffer jobOffer;
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="idUser", referencedColumnName="id", insertable=false, updatable=false)
	private User user;
	private static final long serialVersionUID = 1L;

	public JobApplication() {
		super();
	}   
	 
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public JobApplicationPK getJobApplicationPK() {
		return jobApplicationPK;
	}

	public void setJobApplicationPK(JobApplicationPK jobApplicationPK) {
		this.jobApplicationPK = jobApplicationPK;
	}

	public JobOffer getJobOffer() {
		return jobOffer;
	}

	public void setJobOffer(JobOffer jobOffer) {
		this.jobOffer = jobOffer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "JobApplication [status=" + status + ", jobApplicationPK=" + jobApplicationPK + ", jobOffer=" + jobOffer
				+ ", user=" + user + "]";
	}
	
	
	
	
   
}
