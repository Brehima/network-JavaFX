package tn.redhats.network.jsf.managedBeans;


import java.sql.Timestamp;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.redhats.network.networkServer.entities.CandidateProfile;
import tn.redhats.network.networkServer.entities.Profile;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.enumeration.Role;
import tn.redhats.network.networkServer.services_impl.CandidatProfilService;

@ManagedBean
@SessionScoped
public class SignUpBean {
	
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private Date birthDate;
	private String sexe;
	private String introduction;
	private String image;
	@EJB
	CandidatProfilService candidateService;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
    public String SignUp()
    {
    	User user = new User();
    	user.setFirstName(firstName);
    	user.setLastName(lastName);
    	user.setEmail(email);
    	user.setUsername(username);
    	CandidateProfile profile = new CandidateProfile();
    	profile.setIntroduction(introduction);
    	profile.setSexe(sexe);
    	profile.setDateNaissance(new Timestamp(birthDate.getTime()));
    
    	user.setPassword(password);
    	user.setRole(Role.Candidate);
    	user.setProfile(profile);
    
    	candidateService.signUp(user);
    	return null;
    }
	
}
