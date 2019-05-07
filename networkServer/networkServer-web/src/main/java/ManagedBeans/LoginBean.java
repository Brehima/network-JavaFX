package ManagedBeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import tn.redhats.network.networkServer.entities.EnterpriseProfile;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.enumeration.Role;
import tn.redhats.network.networkServer.services_impl.EnterpriseService;

@ManagedBean
@SessionScoped
public class LoginBean {
	private String email;
	private String password;
	private User user;
	private String enteredCode="";
	private String generatedCode;
	private String userName;
	
	private EnterpriseProfile ep;
	private String EnterpriseName;
	private String introduction;
	private String employeesNumber;
	private String jobField;
	private String website;
	private List<String> locations = new ArrayList<String>();
	
	
	

	
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getLocations() {
		return locations;
	}

	public void setLocations(List<String> locations) {
		this.locations = locations;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	

	public String getEmployeesNumber() {
		return employeesNumber;
	}

	public void setEmployeesNumber(String employeesNumber) {
		this.employeesNumber = employeesNumber;
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

	public String getEnterpriseName() {
		return EnterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		EnterpriseName = enterpriseName;
	}

	public EnterpriseProfile getEp() {
		return ep;
	}

	public void setEp(EnterpriseProfile ep) {
		this.ep = ep;
	}

	public String getEnteredCode() {
		return enteredCode;
	}

	public void setEnteredCode(String enteredCode) {
		this.enteredCode = enteredCode;
	}

	public String getGeneratedCode() {
		return generatedCode;
	}

	public void setGeneratedCode(String generatedCode) {
		this.generatedCode = generatedCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public EnterpriseService getEs() {
		return es;
	}

	public void setEs(EnterpriseService es) {
		this.es = es;
	}

	@EJB
	EnterpriseService es;
	
	public String doLogin() {
		String navigateTo = "null";
		user = es.signInStepOne(email);
		
		if(user != null && user.getRole() == Role.ApplicationAdministrator) {
			
			navigateTo = "/users?faces-redirect=true";
			
		} else if(user != null && user.getRole() != Role.ApplicationAdministrator) {
			
			generatedCode = generateCode();
			System.out.println("Generated code : "+generatedCode);
			
			/*
			sendEmailBySSl(generatedCode, user.getEmail());
			*/
			userName = user.getFirstName()+" "+user.getLastName();
			EnterpriseName = findProfile(user.getProfile().getId()).getEnterpriseName();
			employeesNumber = findProfile(user.getProfile().getId()).getEmployeesNumber();
			introduction = findProfile(user.getProfile().getId()).getIntroduction();
			jobField = findProfile(user.getProfile().getId()).getJobField();
			website = findProfile(user.getProfile().getId()).getWebsite();
			locations = findProfile(user.getProfile().getId()).getLocations();
			
			navigateTo = "/twofact?faces-redirect=true";
			
			
			
		} else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad credentials !"));
		}
		return navigateTo;
	}
	

	public String doAuth() {
		String navigateTo = "null";
		if(enteredCode.equals(generatedCode)) {
			
			
			navigateTo = "/profile?faces-redirect=true";
		}
		else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Code !"));
		}
		return navigateTo;
	}
	
	public String deleteProfile() {
		String navigateTo = "/home?faces-redirect=true";
		int id = findProfile(user.getProfile().getId()).getId();
		es.removeEnterprise(id);
		return navigateTo;
	}
	
	public EnterpriseProfile findProfile(int id) {
		ep = es.findEnterpriseById(id);
		return ep;
	}
	
	
	public String generateCode()
    {
    	  String alphabet= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789&é(-_@=)}{$*%^!:+~";
          String s = "";
          Random random = new Random();
       
          
          for (int i = 0; i < 10; i++) {
              char c = alphabet.charAt(random.nextInt(alphabet.length()));
              s+=c;
          }
           
         return s;
    }
	
	public String updateProfile() {
		
		
		
		EnterpriseProfile newProfile;
		newProfile = es.findEnterpriseById(user.getProfile().getId());
		
		
		
		newProfile.setEmployeesNumber(employeesNumber);
		newProfile.setEnterpriseName(EnterpriseName);
		newProfile.setIntroduction(introduction);
		newProfile.setJobField(jobField);
		newProfile.setWebsite(website);
		
		
		String navigateTo = "/profile?faces-redirect=true";
		
		es.updateEnterpriseProfile(newProfile.getId(), newProfile.getIntroduction(), 
				newProfile.getPhoto(), newProfile.getJobField(), newProfile.getLocations(), 
				newProfile.getWebsite(), newProfile.getEmployeesNumber(), newProfile.getEnterpriseName());
		
				
		return navigateTo;
	}
    
	/*
    public Boolean sendEmailBySSl(String code,String userEmail){
    	Properties properties = new Properties();
    	properties.put("mail.smtp.host","smtp.gmail.com");
    	properties.put("mail.smtp.socketFactory.port","465");
    	properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
    	properties.put("mail.smtp.auth","true");
    	properties.put("mail.smtp.port","465");
    	Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
    		protected PasswordAuthentication getPasswordAuthentication() {
			  return new PasswordAuthentication("projectnetwork87@gmail.com", "netw@rKPr0jec7");	
			}
    	});
    	try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("projectnetwork87@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
			message.setSubject("Network account Validation");
			message.setText(" your account validation code is:"+code+"\n\n\n\n Best regards, Network project");
			Transport.send(message);
			System.out.println(" code send is:"+code);
			return true;
		} catch (MessagingException e) {
			System.out.println("Can't send codes");
		}
    	return false;
    }
    */
	
	
}
