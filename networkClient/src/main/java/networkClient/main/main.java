package networkClient.main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.mindrot.jbcrypt.BCrypt;

import javassist.util.proxy.Proxy;
import tn.redhats.network.networkServer.services.CandidatProfilServiceRemote;
import tn.redhats.network.networkClient.javafx.candidateProfile.EmailValidator;
import tn.redhats.network.networkClient.javafx.candidateProfile.SignUp_fxmlController;
import tn.redhats.network.networkClient.javafx.candidateProfile.passwordValidator;
import tn.redhats.network.networkServer.entities.CandidateProfile;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.enumeration.Role;
import tn.redhats.network.networkServer.services.AdminServiceRemote;
import tn.redhats.network.networkServer.services.CandidatProfilServiceRemote;

public class main {
   
	public static CandidatProfilServiceRemote getProxy() throws NamingException
	{
		String jndiName1="networkServer-ear/networkServer-ejb/CandidatProfilService!tn.redhats.network.networkServer.services.CandidatProfilServiceRemote";
		Context context =  new InitialContext();
		//CandidatProfilServiceRemote proxy= (CandidatProfilServiceRemote) context.lookup(jndiName1);
		CandidatProfilServiceRemote proxy = (CandidatProfilServiceRemote) context.lookup(jndiName1);
		return proxy;
	}
	public static void main(String[] args) throws NamingException{
		
	//	String jndiName = "networkServer-ear/networkServer-ejb/AdminService!tn.redhats.network.networkServer.services.AdminServiceRemote";
	//	String jndiName1="networkServer-ear/networkServer-ejb/CandidatProfilService!tn.redhats.network.networkServer.services.CandidatProfilServiceRemote";
	//	Context context =  new InitialContext();
		//CandidatProfilServiceRemote proxy= (CandidatProfilServiceRemote) context.lookup(jndiName1);
//		CandidatProfilServiceRemote proxy = getProxy();
//		User user = new User();
//		CandidateProfile candidate = new CandidateProfile();
//		candidate.setIntroduction("ceci est une introduction");
//		candidate.setPhoto("photo");
//		
//		user.setFirstName("toto");
//		user.setLastName("toto");
//		user.setUsername("toto");
//		user.setEmail("toto@toto.toto");
//		user.setPassword("toto");
//		user.setRole(Role.Candidate);
//		candidate.getUsers().add(user);
//		user.setProfile(candidate);
//		System.out.print(proxy.signUp(user));
//		System.out.print(proxy.signInStepOne("toto"));
		/*candidate.setId(3);
		System.out.println(proxy.findCandidatById(1).toString());
		candidate.setIntroduction("ceci est un update");
		System.out.println(proxy.updateProfil(candidate));*/
		
		//SignUp_fxmlController.sendEmailBySSl(SignUp_fxmlController.generateCode(),"brehima.coulibaly@esprit.tn");
		
	//  System.out.println(	BCrypt.hashpw("admin", BCrypt.gensalt()) );
	}

}
