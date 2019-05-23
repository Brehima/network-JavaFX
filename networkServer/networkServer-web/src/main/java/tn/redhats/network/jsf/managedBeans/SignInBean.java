package tn.redhats.network.jsf.managedBeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

import tn.redhats.network.networkServer.entities.CandidateProfile;
import tn.redhats.network.networkServer.entities.EnterpriseProfile;
import tn.redhats.network.networkServer.entities.JobOffer;
import tn.redhats.network.networkServer.entities.Profile;
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
	private String introduction;
	private List<String> competence;
	private User connectedUser;
	private List<User> friends;
	private User watchedProfile;
	private EnterpriseProfile enterprise;
	private String keyword;
	private List<EnterpriseProfile> followedEnterprise;
	private List<JobOffer> jobs;
	private String searchMail;
	private String booleanString;
	@EJB
	CandidatProfilService candidateService;
    @PostConstruct
	public void init()
	{
    	 booleanString="";
    	 keyword="";
    	 followedEnterprise = new ArrayList<EnterpriseProfile>();
    	 jobs = new ArrayList<JobOffer>();
    	
	}
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
				System.out.println("**************");
			}
	    	return false;
	    }
	public String getUsername() {
		return username;
	}
	
	public List<JobOffer> getJobs() {
		CandidateProfile profile = (CandidateProfile) connectedUser.getProfile();
		List<JobOffer> j;
		for(String key: profile.getSkills())
		{
		  	j = candidateService.findJobs(key);
		  	if(j.size()>0)
		  	{
		  		if(jobs.size()==0)
		  		{
		  			jobs=j;
		  		}
		  		else
		  		{	
		  		  
		  			for(JobOffer bigJob: j)
		  			{
		  				if(jobs.contains(bigJob)==false)
		  				{
		  					jobs.add(bigJob);
		  				}
		  				
		  			}
		  		  	
		  		}
		  	}
		}
		
		return jobs;
	}
	public void setJobs(List<JobOffer> jobs) {
		this.jobs = jobs;
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
	
	public EnterpriseProfile getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(EnterpriseProfile enterprise) {
		this.enterprise = enterprise;
	}
	public User getConnectedUser() {
	
		return connectedUser;
	}
	public void setConnectedUser(User connectedUser) {
		this.connectedUser = connectedUser;
		
	}
	
	
	public User getWatchedProfile() {
		return watchedProfile;
	}
	public void setWatchedProfile(User watchedProfile) {
		this.watchedProfile = watchedProfile;
	}
	public String getIntroduction() {
		introduction = connectedUser.getProfile().getIntroduction();
		return introduction;
	}
	public void setIntroduction(String introduction) {
				this.introduction = introduction;
				connectedUser.getProfile().setIntroduction(introduction);
				candidateService.updateAllUser(connectedUser);
	}
	
	
	public List<String> getCompetence() {
		competence =  ((CandidateProfile)connectedUser.getProfile()).getSkills();
		return competence;
	}
	public void setCompetence(List<String> competence) {
		CandidateProfile profile = (CandidateProfile)connectedUser.getProfile();
		profile.setSkills(competence);
		connectedUser.setProfile(profile);
		this.competence =  competence;
		candidateService.updateAllUser(connectedUser);
	}
	
	public String getSearchMail() {
		return searchMail;
	}
	public void setSearchMail(String searchMail) {
		this.searchMail = searchMail;
	
	}
	public String setCrazyMail(String mail)
	{
		setSearchMail(mail);
		return getSearchMail();
	}
	
	public String getKeyword() {
		System.out.println("--------------------------------------------kkworget---"+keyword);
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;

		System.out.println("--------------------------------------------kkworset---"+this.keyword);
	}
	
	public String getBooleanString() {
		return booleanString;
	}
	public void setBooleanString(String booleanString) {
		this.booleanString = booleanString;
	}
	public String showOtherProfile()
	{
		String email=searchMail;
		System.out.println("-----------------------------------------------"+email);
		watchedProfile = candidateService.findUserByEmail(email);
		if(watchedProfile!=null)
		{
			return "/templateClient/contactProfile.jsf?faces-redirect=true";
		}
		return null;
	}
	public String showEnterprise(String website)
	{
		//affecting to keyword the selected value to use it later
		List<EnterpriseProfile> companies = candidateService.getallEnterprise(website);
		//keyword = website;
	    if(companies!=null && companies.size() > 0)
	    {
	    	enterprise = companies.get(0);
	    	return "/templateClient/enterpriseProfile.jsf?faces-redirect=true";
	    }
		return null;
		
	}
	
	public List<EnterpriseProfile> getFollowedEnterprise() {
		for(String ch: ((CandidateProfile)connectedUser.getProfile()).getFollowedEnterprises())
		{
		  if(candidateService.getallEnterprise(ch)!=null)
		  {
				EnterpriseProfile ent = candidateService.getallEnterprise(ch).get(0);
				System.out.println("*******************enter:"+ent);
				if(followedEnterprise.size()==0)
				{
					followedEnterprise.add(ent);
				}
				else
				{
				
					for(EnterpriseProfile i : followedEnterprise)
					{
						if(!i.getWebsite().equals(ent.getWebsite()) )
							{
								followedEnterprise.add(ent);
							}
					}
				}	
			
		  }
			
		}
		System.out.println("-----------------------follow:"+followedEnterprise);
		return followedEnterprise;
	}
	public void setFollowedEnterprise(List<EnterpriseProfile> followedEnterprise) {
	
		this.followedEnterprise = followedEnterprise;
	}
	public void followEnterprise(String ent)
	{
		CandidateProfile profile = (CandidateProfile)connectedUser.getProfile();
		System.out.println("-----------------------param:"+ent);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		if(profile.getFollowedEnterprises().contains(ent)==false)
		{
			profile.getFollowedEnterprises().add(ent);
			booleanString="Unfollow";
			
			addMessage("You are now following "+enterprise.getWebsite());
			connectedUser.setProfile(profile);
			candidateService.updateAllUser(connectedUser);
			
			try {
				ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
				} 
			catch (IOException e) 
			    {	
					e.printStackTrace();
				}
		}
		else
		{
			profile.getFollowedEnterprises().remove(ent);
			setBooleanString("Follow");
			addMessage("You are not anymore  following "+enterprise.getWebsite());
			connectedUser.setProfile(profile);
			candidateService.updateAllUser(connectedUser);
		
			try {
				ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
				} 
			catch (IOException e) 
			    {	
					e.printStackTrace();
				}
		}
		
	}
	public void unfollowEnterprise(String ent)
	{
		CandidateProfile profile = (CandidateProfile)connectedUser.getProfile();
	    for(String ch: profile.getFollowedEnterprises())
	    {
	    	if(ch.equals(ent))
	    	{
	    		List<String> supp = profile.getFollowedEnterprises();
	    		supp.remove(ch);
	    		profile.setFollowedEnterprises(supp);
	    	}
	    }
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		
		//addMessage("You are not anymore  following "+enterprise.getWebsite());
		connectedUser.setProfile(profile);
		candidateService.updateAllUser(connectedUser);
		System.out.println("-----------------------unfollow profile:"+ent);
		this.followedEnterprise = getFollowedEnterprise();
		
		try {
			ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
			} 
		catch (IOException e) 
		    {	
				e.printStackTrace();
			}
	}
	public String setPhotoProfile(String profile)
	{
		//D://cours/JEE/workspace_PI/users_profile/F742D4B21F5E5D557A85824FBBBB27281D47B120FBC9F4527A865048042A6A91.png
	
		//String profile = connectedUser.getProfile().getPhoto();
		if(profile!=null)
		{
			String[]tab=profile.split("\\/");			
			profile=tab[6];
		}     		
		return profile;
	}
	
	public 	String step1Finish()
	{
		User u = candidateService.signInStepOne(username);
		System.out.println("---------------passs--------------"+u);
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
			friends = connectedUser.getUsers();
			System.out.println("-----------------------friends :"+friends);
			
			return "/templateClient/profile.jsf?faces-redirect=true";
		}
		 FacesContext.getCurrentInstance().addMessage("signIn2Form:btn", new FacesMessage("wrong code"));	    
		 return null;
	}
	
	public List<User> getFriends() {
		return friends;
	}
	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	public String doLogout()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/templateClient/SignIn.jsf?faces-redirect=true";
	}
    public CandidateProfile profileCandidate()
    {
    	return (CandidateProfile)watchedProfile.getProfile();
    }
    public List<EnterpriseProfile> findEnterprise()
    {
    	List<EnterpriseProfile> companies = candidateService.getallEnterprise(keyword);
    	if(companies!=null)
    	{
    		System.out.println("----------------------------------key"+keyword);
    		return companies;
    	}
    	return null;
    }
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
