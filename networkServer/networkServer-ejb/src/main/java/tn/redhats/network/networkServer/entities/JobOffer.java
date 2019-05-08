package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
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
	
	public JobOffer(String description, String expertiseLevel, String location, List<JobApplication> jobApplication) {
		super();
		this.description = description;
		this.expertiseLevel = expertiseLevel;
		this.location = location;
		this.jobApplication = jobApplication;
	}
	public JobOffer(String description, String expertiseLevel, String location) {
		super();
		this.description = description;
		this.expertiseLevel = expertiseLevel;
		this.location = location;
	}
	public JobOffer(int id, String description, String expertiseLevel, String location) {
		super();
		this.id = id;
		this.description = description;
		this.expertiseLevel = expertiseLevel;
		this.location = location;
	}
	@OneToMany(mappedBy="jobOffer")
	@Column
	@ElementCollection(targetClass=JobApplication.class,fetch=FetchType.EAGER)
	private List<JobApplication> jobApplication;
	private static final long serialVersionUID = 1L;

	public JobOffer() {
		super();
		 jobApplication = new ArrayList< JobApplication>();
	}   
	public JobOffer(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
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
				+ ", location=" + location;
	}
	
	
   
}
