package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: JobOffer
 *
 */
@Entity

public class JobOffer implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String description;
	private String expertiseLevel;
	private String location;
	@OneToMany(mappedBy="jobOffer")
	@Column
	@ElementCollection(targetClass=JobApplication.class)
	private List<JobApplication> jobApplication;
	private static final long serialVersionUID = 1L;

	public JobOffer() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getExpertiseLevel() {
		return this.expertiseLevel;
	}

	public void setExpertiseLevel(String expertiseLevel) {
		this.expertiseLevel = expertiseLevel;
	}   
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public List<JobApplication> getJobApplication() {
		return jobApplication;
	}
	public void setJobApplication(List<JobApplication> jobApplication) {
		this.jobApplication = jobApplication;
	}
	@Override
	public String toString() {
		return "JobOffer [id=" + id + ", description=" + description + ", expertiseLevel=" + expertiseLevel
				+ ", location=" + location + ", jobApplication=" + jobApplication + "]";
	}
	
	
   
}
