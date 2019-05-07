package ManagedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import tn.redhats.network.networkServer.entities.EnterpriseProfile;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.enumeration.Role;
import tn.redhats.network.networkServer.services_impl.EnterpriseService;

@ManagedBean
@SessionScoped
public class EnterpriseBean {

	@EJB
	EnterpriseService es;
	
	
	
	private String introduction;
	private String jobField;
	private String website;
	private String employeesNumber;
	private String enterpriseName;
	private String location;
	private List<String> locations = new ArrayList<String>();
	
	
	
	
	private String adminFirstName;
	private String adminLastName;
	private String adminEmail;
	private String adminPassword;
	private String adminUsername;
	
	
	
	
	private String hrFirstName;
	private String hrLastName;
	private String hrEmail;
	private String hrPassword;
	private String hrUsername;
	
	
	
	
	private String pmFirstName;
	private String pmLastName;
	private String pmEmail;
	private String pmPassword;
	private String pmUsername;
	
	
	
	private String rmFirstName;
	private String rmLastName;
	private String rmEmail;
	private String rmPassword;
	private String rmUsername;
	
	
	private List<EnterpriseProfile> profiles = new ArrayList<EnterpriseProfile>();
	private List<User> users = new ArrayList<User>();
	
	
	
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public void setProfiles(List<EnterpriseProfile> profiles) {
		this.profiles = profiles;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getJobField() {
		return jobField;
	}
	public void setJobField(String jobField) {
		this.jobField = jobField;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getEmployeesNumber() {
		return employeesNumber;
	}
	public void setEmployeesNumber(String employeesNumber) {
		this.employeesNumber = employeesNumber;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getAdminFirstName() {
		return adminFirstName;
	}
	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}
	public String getAdminLastName() {
		return adminLastName;
	}
	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	
	public String getHrFirstName() {
		return hrFirstName;
	}
	public void setHrFirstName(String hrFirstName) {
		this.hrFirstName = hrFirstName;
	}
	public String getHrLastName() {
		return hrLastName;
	}
	public void setHrLastName(String hrLastName) {
		this.hrLastName = hrLastName;
	}
	public String getHrEmail() {
		return hrEmail;
	}
	public void setHrEmail(String hrEmail) {
		this.hrEmail = hrEmail;
	}
	public String getHrPassword() {
		return hrPassword;
	}
	public void setHrPassword(String hrPassword) {
		this.hrPassword = hrPassword;
	}
	public String getHrUsername() {
		return hrUsername;
	}
	public void setHrUsername(String hrUsername) {
		this.hrUsername = hrUsername;
	}
	
	public String getPmFirstName() {
		return pmFirstName;
	}
	public void setPmFirstName(String pmFirstName) {
		this.pmFirstName = pmFirstName;
	}
	public String getPmLastName() {
		return pmLastName;
	}
	public void setPmLastName(String pmLastName) {
		this.pmLastName = pmLastName;
	}
	public String getPmEmail() {
		return pmEmail;
	}
	public void setPmEmail(String pmEmail) {
		this.pmEmail = pmEmail;
	}
	public String getPmPassword() {
		return pmPassword;
	}
	public void setPmPassword(String pmPassword) {
		this.pmPassword = pmPassword;
	}
	public String getPmUsername() {
		return pmUsername;
	}
	public void setPmUsername(String pmUsername) {
		this.pmUsername = pmUsername;
	}
	
	public String getRmFirstName() {
		return rmFirstName;
	}
	public void setRmFirstName(String rmFirstName) {
		this.rmFirstName = rmFirstName;
	}
	public String getRmLastName() {
		return rmLastName;
	}
	public void setRmLastName(String rmLastName) {
		this.rmLastName = rmLastName;
	}
	public String getRmEmail() {
		return rmEmail;
	}
	public void setRmEmail(String rmEmail) {
		this.rmEmail = rmEmail;
	}
	public String getRmPassword() {
		return rmPassword;
	}
	public void setRmPassword(String rmPassword) {
		this.rmPassword = rmPassword;
	}
	public String getRmUsername() {
		return rmUsername;
	}
	public void setRmUsername(String rmUsername) {
		this.rmUsername = rmUsername;
	}
	
	public void addEnterprise() {
		
		EnterpriseProfile ep = new EnterpriseProfile();
		ep.setEnterpriseName(enterpriseName);
		ep.setIntroduction(introduction);
		ep.setEmployeesNumber(employeesNumber);
		ep.setJobField(jobField);
		ep.setWebsite(website);
		locations.add(location);
		ep.setLocations(locations);
		
		User EnterpriseAdministrator = new User();
		EnterpriseAdministrator.setFirstName(adminFirstName);
		EnterpriseAdministrator.setLastName(adminLastName);
		EnterpriseAdministrator.setEmail(adminEmail);
		EnterpriseAdministrator.setPassword(adminPassword);
		EnterpriseAdministrator.setUsername(adminUsername);
		EnterpriseAdministrator.setRole(Role.EnterpriseAdministrator);
		EnterpriseAdministrator.setProfile(ep);
		
		
		User HRManager = new User();
		HRManager.setFirstName(hrFirstName);
		HRManager.setLastName(hrLastName);
		HRManager.setEmail(hrEmail);
		HRManager.setPassword(hrPassword);
		HRManager.setUsername(hrUsername);
		HRManager.setRole(Role.HRManager);
		HRManager.setProfile(ep);
		
		User ProjectManager = new User();
		ProjectManager.setFirstName(pmFirstName);
		ProjectManager.setLastName(pmLastName);
		ProjectManager.setEmail(pmEmail);
		ProjectManager.setPassword(pmPassword);
		ProjectManager.setUsername(pmUsername);
		ProjectManager.setRole(Role.ProjectManager);
		ProjectManager.setProfile(ep);
		
		User RecruitementManager = new User();
		RecruitementManager.setFirstName(rmFirstName);
		RecruitementManager.setLastName(rmLastName);
		RecruitementManager.setEmail(rmEmail);
		RecruitementManager.setPassword(rmPassword);
		RecruitementManager.setUsername(rmUsername);
		RecruitementManager.setRole(Role.RecruitementsManager);
		RecruitementManager.setProfile(ep);
		
		
		es.addEnterprise(ep, EnterpriseAdministrator, HRManager, ProjectManager, RecruitementManager);
		
	}
	
	public List<EnterpriseProfile> getProfiles(){
		profiles = es.findAllEnterprises();
		return profiles;
	}
		
	
	public String showUsers(int id) {
		String navigateTo = "/usersdetails?faces-redirect=true";
		users = es.EnterpriseProfileUsers(id);
		return navigateTo;
	}
	
	/*
	public List<User> getUsers(int id){
		users = es.EnterpriseProfileUsers(id);
		return users;
	}
	*/
	
	public void supprimerProfile(int id) {
		es.removeEnterprise(id);
	}
	
	
	
	
	
}
