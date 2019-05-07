package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: EnterpriseProfile
 *
 */
@Entity

public class EnterpriseProfile extends Profile implements Serializable {

	
	private String jobField;
	@Column
	@ElementCollection(targetClass=String.class, fetch=FetchType.EAGER)
	private List<String> locations;
	private String website;
	private String employeesNumber;
	@Column
	@ElementCollection(targetClass=String.class, fetch=FetchType.EAGER)
	private List<String> followers;
	private String enterpriseName;
	
	private static final long serialVersionUID = 1L;
	


	public EnterpriseProfile(String introduction, String jobField, String website, String employeesNumber,
			String enterpriseName) {
		super(introduction);
		this.jobField = jobField;
		this.website = website;
		this.employeesNumber = employeesNumber;
		this.enterpriseName = enterpriseName;
	}
	


	public EnterpriseProfile(String introduction, String photo, List<User> users, String jobField,
			List<String> locations, String website, String employeesNumber, String enterpriseName) {
		super(introduction, photo, users);
		this.jobField = jobField;
		this.locations = locations;
		this.website = website;
		this.employeesNumber = employeesNumber;
		this.enterpriseName = enterpriseName;
	}


	


	public String getEmployeesNumber() {
		return employeesNumber;
	}



	public void setEmployeesNumber(String employeesNumber) {
		this.employeesNumber = employeesNumber;
	}



	public List<String> getFollowers() {
		return followers;
	}


	public void setFollowers(List<String> followers) {
		this.followers = followers;
	}


	public String getEnterpriseName() {
		return enterpriseName;
	}


	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}


	public EnterpriseProfile() {
		super();
		locations = new ArrayList<String>();
	}  


	public String getJobField() {
		return this.jobField;
	}

	public void setJobField(String jobField) {
		this.jobField = jobField;
	}   
	public List<String> getLocations() {
		return this.locations;
	}

	public void setLocations(List<String> locations) {
		this.locations = locations;
	}   
	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}   
	
	
	public void setUser(User user) {
		super.users.add(user);
	}
	
	public List<User> getUsers() {
		return super.users;
	}



	@Override
	public String toString() {
		return "EnterpriseProfile [jobField=" + jobField + ", website=" + website + ", employeesNumber="
				+ employeesNumber + ", enterpriseName=" + enterpriseName + ", id=" + id + ", introduction="
				+ introduction + "]";
	}



	

	
	

	
	
	
	
	

	
	

	

	

	
	
	
   
}
