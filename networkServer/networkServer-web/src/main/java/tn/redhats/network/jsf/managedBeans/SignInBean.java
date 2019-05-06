package tn.redhats.network.jsf.managedBeans;

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

import org.mindrot.jbcrypt.BCrypt;

import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.services_impl.CandidatProfilService;

@ManagedBean
@SessionScoped
public class SignInBean 
{
	private String username;
	private String password;
	private String user2FACode;
	private String  code2FA;
	private User connectedUser;
	@EJB
	CandidatProfilService candidateService;
    
	 public  String hashPassword(String pass)
	    {

	    	String chaineHasher=BCrypt.hashpw(pass, BCrypt.gensalt());   	
	    	return chaineHasher;
	    }
	    public  String generateCode()
	    {
	    	  String alphabet= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789&é(-_@=)}{$*%^!:+~";
	          String s = "";
	          Random random = new Random();
	       
	          
	          for (int i = 0; i < 10; i++) {
	              char c = alphabet.charAt(random.nextInt(alphabet.length()));
	              s+=c;
	          }
	         System.out.println("-----------------------code is:"+s);  
	      
	         return s;
	    }
	    public  Boolean sendEmailBySSl(String code,String userEmail)
	    {
	    	Properties properties = new Properties();
	    	properties.put("mail.smtp.host","smtp.gmail.com");
	    	properties.put("mail.smtp.socketFactory.port","465");
	    	properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	    	properties.put("mail.smtp.auth","true");
	    	properties.put("mail.smtp.port","465");
	    	Session session = Session.getInstance(properties,new javax.mail.Authenticator() {
	    		protected PasswordAuthentication getPasswordAuthentication() {
				  return new PasswordAuthentication("projectnetwork87@gmail.com", "netw@rKPr0jec7");	
				}
	    	});
	    	try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("projectnetwork87@gmail.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
				message.setSubject("Network account Validation");
				message.setText(" your account validation code is:"+code+"\n\n\n\n Best regards Network");
				Transport.send(message);
				System.out.println(" code send is:"+code);
				return true;
			} catch (MessagingException e) {
				System.out.println("impossible d'envoyer le mail");
			}
	    	return false;
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

	public String getCode2FA() {
		return code2FA;
	}

	public void setCode2FA(String code2fa) {
		code2FA = code2fa;
	}
	
	public String getUser2FACode() {
		return user2FACode;
	}
	public void setUser2FACode(String user2faCode) {
		user2FACode = user2faCode;
	}
	
	public User getConnectedUser() {
		return connectedUser;
	}
	public void setConnectedUser(User connectedUser) {
		this.connectedUser = connectedUser;
	}
	public 	String step1Finish()
	{
		User u = candidateService.signInStepOne(username);
		if(u!=null)
		{
			if(BCrypt.checkpw(password,  u.getPassword()))
			{
				this.code2FA  = generateCode();
				sendEmailBySSl(code2FA,u.getEmail());
				return "/templateClient/SignIn2.jsf?faces-redirect=true";
			}
		}
	    FacesContext.getCurrentInstance().addMessage("signInForm:btn", new FacesMessage("wrong username or password"));
	    
		return null;
	}
	public String step2Finish()
	{
		if(user2FACode.equals(code2FA))
		{
			connectedUser =  candidateService.signInStepOne(username);
			return "/templateClient/profile.jsf?faces-redirect=true";
		}
		 FacesContext.getCurrentInstance().addMessage("signIn2Form:btn", new FacesMessage("wrong code"));	    
		 return null;
	}
	public String doLogout()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/templateClient/SignIn.jsf?faces-redirect=true";
	}
	
}
