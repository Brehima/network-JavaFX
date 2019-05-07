package networkClient.main;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.redhats.network.networkServer.entities.EnterpriseProfile;
import tn.redhats.network.networkServer.entities.JobOffer;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.enumeration.Role;
import tn.redhats.network.networkServer.services.AdminServiceRemote;
import tn.redhats.network.networkServer.services.EnterpriseServiceRemote;

public class main {
	
	public static EnterpriseServiceRemote getEnterpriseProfileProxy() throws NamingException{
		
		String jndiEnterpriseServiceRemote = "networkServer-ear/networkServer-ejb/EnterpriseService!tn.redhats.network.networkServer.services.EnterpriseServiceRemote";
		Context context =  new InitialContext();
		EnterpriseServiceRemote proxyEnterpriseProfile = (EnterpriseServiceRemote) context.lookup(jndiEnterpriseServiceRemote);
		return proxyEnterpriseProfile;
	}

	public static void main(String[] args) throws NamingException{
		
		String jndiEnterpriseServiceRemote = "networkServer-ear/networkServer-ejb/EnterpriseService!tn.redhats.network.networkServer.services.EnterpriseServiceRemote";
		Context context =  new InitialContext();
		EnterpriseServiceRemote proxyEnterpriseProfile = (EnterpriseServiceRemote) context.lookup(jndiEnterpriseServiceRemote);
				
		
		
		
		
		/*
		JobOffer jo = new JobOffer();
		jo.setDescription("Data scientist");
		jo.setExpertiseLevel("3 years of experience");
		jo.setLocation("Mali");
		proxyEnterpriseProfile.addJobOffer(jo);
		*/
		
		//System.out.println(proxyEnterpriseProfile.findAllJobOffers());
		
		
		//proxyEnterpriseProfile.addEnterprise(enterpriseProfile, EnterpriseAdministrator, HRManager, ProjectManager, RecruitementManager);

		//proxyEnterpriseProfile.showEnterpriseById(50);
		
		//System.out.println(proxyEnterpriseProfile.findEnterpriseById(55));
		
		//System.out.println(proxyEnterpriseProfile.EnterpriseProfileUsers(5));
		
		//System.out.println(proxyEnterpriseProfile.findAllEnterprises());
		
		//proxyEnterpriseProfile.removeEnterprise(50);
		
		
		//System.out.println(proxyEnterpriseProfile.findLocations(55));
		
		
		
		//proxyEnterpriseProfile.removeEnterprise(enterpriseProfile);
		
		
		
		/*ArrayList<String> loc = new ArrayList<String>();
		loc.add("Tunis");
		loc.add("Paris");
		proxyEnterpriseProfile.updateEnterpriseProfile(55, "new intro", "new photo", "jobii", loc, "webbb", 5000);
		*/
		
		
		//System.out.println(proxyEnterpriseProfile.findEnterpriseById(55));
		
		//proxyEnterpriseProfile.removeEnterprise(60);
		
		//System.out.println(getEnterpriseProfileProxy().findEventsList(120));
		
		
		
	}

}
