package networkClient.main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.redhats.network.networkServer.services.AdminServiceRemote;

public class main {

	public static void main(String[] args) throws NamingException{
		
		String jndiName = "networkServer-ear/networkServer-ejb/AdminService!tn.redhats.network.networkServer.services.AdminServiceRemote";
		Context context =  new InitialContext();
		AdminServiceRemote proxy = (AdminServiceRemote) context.lookup(jndiName);
		System.out.print(proxy.sayHello("Hello test !"));

	}

}
