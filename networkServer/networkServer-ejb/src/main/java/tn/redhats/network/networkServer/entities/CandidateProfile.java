package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CandidateProfile
 *
 */
@Entity

public class CandidateProfile extends Profile implements Serializable {

	@Column
	private String sexe;
	@Column
	private Timestamp dateNaissance;
	@Column
	@ElementCollection(targetClass=String.class,fetch= FetchType.EAGER)
	private List<String> education;
	@Column
	@ElementCollection(targetClass=String.class,fetch= FetchType.EAGER)
	private List<String> volunteeringExperiences;
	@Column
	@ElementCollection(targetClass=String.class,fetch= FetchType.EAGER)
	private List<String> certifications;
	@Column
	@ElementCollection(targetClass=String.class,fetch= FetchType.EAGER)
	private List<String> skills;
	@Column(nullable=true)
	private String cv;
	@Column
	@ElementCollection(targetClass=String.class,fetch= FetchType.EAGER)
	private List<String> followedEnterprises;
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
	
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public Timestamp getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Timestamp dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public List<String> getFollowedEnterprises() {
		return followedEnterprises;
	}
	public void setFollowedEnterprises(List<String> followedEnterprises) {
		this.followedEnterprises = followedEnterprises;
	}
	@Override
	public String toString() {
		return super.toString();// [education=" + education + ", volunteeringExperiences=" + volunteeringExperiences
			//	+ ", certifications=" + certifications + ", skills=" + skills + ", cv=" + cv + "]";
	}
	
	
   
}
