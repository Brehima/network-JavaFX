package networkClient.main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.enumeration.Role;
import tn.redhats.network.networkServer.services.AdminServiceRemote;
import tn.redhats.network.networkServer.services.CandidatProfilServiceRemote;

public class main {

	public static void main(String[] args) throws NamingException{
		
		String jndiName = "networkServer-ear/networkServer-ejb/AdminService!tn.redhats.network.networkServer.services.AdminServiceRemote";
		String jndiName1="networkServer-ear/networkServer-ejb/CandidatProfilService!tn.redhats.network.networkServer.services.CandidatProfilServiceRemote";
		Context context =  new InitialContext();
		CandidatProfilServiceRemote proxy = (CandidatProfilServiceRemote) context.lookup(jndiName1);
		User user = new User();
		user.setFirstName("brehima");
		user.setLastName("coulibaly");
		user.setEmail("brehima.coulibaly@esprit.tn");
		user.setPassword("password");
		user.setRole(Role.Candidate);
		System.out.print(proxy.signUp(user));

	}

}
