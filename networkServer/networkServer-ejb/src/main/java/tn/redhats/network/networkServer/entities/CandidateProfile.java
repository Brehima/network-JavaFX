package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CandidateProfile
 *
 */
@Entity

public class CandidateProfile extends Profile implements Serializable {

	@Column
	@ElementCollection(targetClass=String.class)
	private List<String> education;
	@Column
	@ElementCollection(targetClass=String.class)
	private List<String> volunteeringExperiences;
	@Column
	@ElementCollection(targetClass=String.class)
	private List<String> certifications;
	@Column
	@ElementCollection(targetClass=String.class)
	private List<String> skills;
	@Column(nullable=true)
	private String cv;
	private static final long serialVersionUID = 1L;

	public CandidateProfile() {
		super();
	}   
	public List<String> getEducation() {
		return this.education;
	}

	public void setEducation(List<String> education) {
		this.education = education;
	}   
	public List<String> getVolunteeringExperiences() {
		return this.volunteeringExperiences;
	}

	public void setVolunteeringExperiences(List<String> volunteeringExperiences) {
		this.volunteeringExperiences = volunteeringExperiences;
	}   
	public List<String> getCertifications() {
		return this.certifications;
	}

	public void setCertifications(List<String> certifications) {
		this.certifications = certifications;
	}   
	public List<String> getSkills() {
		return this.skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}   
	public String getCv() {
		return this.cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}
	@Override
	public String toString() {
		return "CandidateProfile [education=" + education + ", volunteeringExperiences=" + volunteeringExperiences
				+ ", certifications=" + certifications + ", skills=" + skills + ", cv=" + cv + "]";
	}
	
	
   
}
