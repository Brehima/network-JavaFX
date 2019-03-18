package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
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
	@ElementCollection(targetClass=String.class)
	private List<String> locations;
	private String website;
	private int employeesNumber;
	@Column
	@ElementCollection(targetClass=String.class)
	private List<String> followers;
	private static final long serialVersionUID = 1L;

	public EnterpriseProfile() {
		super();
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
	public int getEmployeesNumber() {
		return this.employeesNumber;
	}

	public void setEmployeesNumber(int employeesNumber) {
		this.employeesNumber = employeesNumber;
	}
	@Override
	public String toString() {
		return "EnterpriseProfile [jobField=" + jobField + ", locations=" + locations + ", website=" + website
				+ ", employeesNumber=" + employeesNumber + "]";
	}
	
	
   
}
