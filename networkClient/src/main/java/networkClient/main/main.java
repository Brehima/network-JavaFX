package networkClient.main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

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
		
		String jndiName = "networkServer-ear/networkServer-ejb/AdminService!tn.redhats.network.networkServer.services.AdminServiceRemote";
		Context context =  new InitialContext();
		AdminServiceRemote proxy = (AdminServiceRemote) context.lookup(jndiName);
		System.out.print(proxy.sayHello("Hello test !"));

	}

}
